package org.aeb.uk.sandbox.typesafe.models

import com.typesafe.config.{ConfigException, ConfigFactory}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class ApplicationConfigSpec extends AnyFlatSpec with should.Matchers {

  it should "return a valid configuration" in {

    val applicationConf = ConfigFactory.load("conf/valid-application.conf")
    val referenceConf = ConfigFactory.load("conf/reference.conf")

    ApplicationConfig(applicationConf, referenceConf) shouldEqual ApplicationConfig("Bob", 62, Seq("tennis"))

  }

  it should "detect an invalid type" in {

    val applicationConf = ConfigFactory.load("conf/invalid-type-application.conf")
    val referenceConf = ConfigFactory.load("conf/reference.conf")

    val thrown = intercept[ConfigException] {
      ApplicationConfig(applicationConf, referenceConf)
    }

    thrown.getMessage should include("app.age has type STRING rather than NUMBER")

  }

  it should "detect a missing type" in {

    val applicationConf = ConfigFactory.load("conf/invalid-missing-field-application.conf")
    val referenceConf = ConfigFactory.load("conf/reference.conf")

    val thrown = intercept[ConfigException] {
      ApplicationConfig(applicationConf, referenceConf)
    }

    thrown.getMessage should include("app.age: No setting at 'app.age', expecting: number")

  }

}
