import sbt._

object Dependencies {

  lazy val akkaVersion = "2.6.18"
  lazy val playJsonVersion = "2.9.2"
  lazy val scalaTestVersion = "3.2.5"
  lazy val sprayJsonVersion = "1.3.6"
  lazy val typesafeConfigVersion = "1.4.1"

  val scalacticDependency = "org.scalactic" %% "scalactic" % scalaTestVersion
  val scalaTestDependency = "org.scalatest" %% "scalatest" % scalaTestVersion

  val rootDependencies = Seq(
      scalacticDependency % Test,
      scalaTestDependency % Test
  )

  val akkaDependencies = Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion
  )

  val playJsonDependencies = Seq(
      "com.typesafe.play" %% "play-json" % playJsonVersion
  )

  val sprayJsonDependencies = Seq(
      "io.spray" %% "spray-json" % sprayJsonVersion
  )

  val typesafeConfigDependencies = Seq(
      "com.typesafe" % "config" % typesafeConfigVersion
  )

}
