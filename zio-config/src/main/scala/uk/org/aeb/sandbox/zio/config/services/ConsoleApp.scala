package uk.org.aeb.sandbox.zio.config.services

import zio._
import uk.org.aeb.sandbox.zio.config.models.ApplicationConfig

final case class ConsoleApp(config: ApplicationConfig) {

  def output = Console.printLine(s"application.conf model: $config")

}

object ConsoleApp {

  val layer: ZLayer[ApplicationConfig, Throwable, ConsoleApp] = ZLayer.fromFunction(
      ConsoleApp.apply _
  )

}
