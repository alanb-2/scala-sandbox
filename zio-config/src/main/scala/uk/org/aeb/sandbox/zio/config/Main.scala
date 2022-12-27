package uk.org.aeb.sandbox.zio.config

import zio._
import zio.Console._

import uk.org.aeb.sandbox.zio.config.services.ConsoleApp
import uk.org.aeb.sandbox.zio.config.models.ApplicationConfig

object Main extends ZIOAppDefault {

  def run = program
    .provide(
        ConsoleApp.layer,
        ApplicationConfig.layer
    )

  val program: ZIO[ConsoleApp, Throwable, Unit] = ZIO.serviceWithZIO[ConsoleApp](_.output)

}
