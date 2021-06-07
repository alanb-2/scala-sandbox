package org.aeb.uk.sandbox.typesafe.utils

import com.typesafe.config.{ConfigException, ConfigFactory}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class ConfigUtilsSpec extends AnyFlatSpec with should.Matchers {

  final val classPath = "conf/valid-nested-application.conf"

  it should "ingest a conf format file" in {

    val applicationConf = ConfigFactory.load( classPath )

    applicationConf.getInt( "foo.bar1.index" ) shouldBe 1
    applicationConf.getString( "foo.bar1.name" ) shouldBe "name1"
    applicationConf.getInt( "foo.bar2.index" ) shouldBe 2
    applicationConf.getString( "foo.bar2.name" ) shouldBe "name2"
    applicationConf.getString( "another.key" ) shouldBe "some text"

  }

  it should "create a new sub-configuration" in {

    val applicationConf = ConfigFactory.load( classPath )
    val fooConf = applicationConf.getConfig( "foo" )

    fooConf.getInt( "bar1.index" ) shouldBe 1
    fooConf.getString( "bar1.name" ) shouldBe "name1"
    fooConf.getInt( "bar2.index" ) shouldBe 2
    fooConf.getString( "bar2.name" ) shouldBe "name2"

    intercept[ConfigException] {
      fooConf.getString( "another.key" )
    }

  }

  it should "extract a list of the top level keys" in {

    val applicationConf = ConfigFactory.load( classPath )

    ConfigUtils.getKeys( applicationConf, "foo" ) shouldBe Array("bar1", "bar2")

  }

}
