package uk.org.aeb.sandbox.zio.config.models

import zio._
import zio.config._
import zio.config.magnolia._
import zio.config.typesafe._

import uk.org.aeb.sandbox.zio.config.models.ApplicationConfig.Servers
import uk.org.aeb.sandbox.zio.config.models.ApplicationConfig.Servers._

final case class ApplicationConfig(
    servers: Servers
)

object ApplicationConfig {

  val layer: ZLayer[Any, Throwable, ApplicationConfig] = ZLayer {
    read(
        descriptor[ApplicationConfig] from TypesafeConfigSource.fromResourcePath
    )
  }

  final case class Servers(
      receiver: Receiver,
      publisher: Publisher
  )

  object Servers {
    final case class Receiver(hostname: String, port: Int)
    final case class Publisher(hostname: String, port: Int)
  }

}
