package uk.org.aeb.sandbox.zio.config.models

import zio._
import zio.config._
import zio.config.magnolia._
import zio.config.typesafe._
import zio.test._
import zio.test.Assertion._

import java.io.File

import ApplicationConfig._
import ApplicationConfig.Servers
import ApplicationConfig.Servers._

object ApplicationConfigSpec extends ZIOSpecDefault {

  def spec =
    suite("ZIO Config Spec")(
        test("Read valid spec") {

          val expected = ApplicationConfig(
              Servers(
                  receiver = Receiver(hostname = "foo.bar.1", port = 9999),
                  publisher = Publisher(hostname = "foo.bar.2", port = 9042)
              )
          )

          val uri =
            new File(getClass.getClassLoader.getResource("conf/valid-application.conf").toURI)

          for {
            source <- read(
                descriptor[ApplicationConfig] from TypesafeConfigSource.fromHoconFile(uri)
            )
          } yield assertTrue(source == expected)

        }
    )

}
