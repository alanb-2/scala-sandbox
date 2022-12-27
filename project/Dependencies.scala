import sbt._

object Dependencies {

  lazy val akkaVersion = "2.7.0"
  lazy val playJsonVersion = "2.9.2"
  lazy val scalaTestVersion = "3.2.14"
  lazy val sprayJsonVersion = "1.3.6"
  lazy val typesafeConfigVersion = "1.4.2"
  lazy val zioConfigVersion = "3.0.6"
  lazy val zioVersion = "2.0.5"

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

  val zioDependencies = Seq(
    "dev.zio" %% "zio" % zioVersion,
    "dev.zio" %% "zio-config" % zioConfigVersion,
    "dev.zio" %% "zio-config-magnolia" % zioConfigVersion,
    "dev.zio" %% "zio-config-typesafe" % zioConfigVersion
  )

  val zioTestDependencies = Seq(
    "dev.zio" %% "zio-test" % zioVersion % "test",
    "dev.zio" %% "zio-test-sbt" % zioVersion % "test"
  )

}
