import sbt._

object Dependencies {

  lazy val scalaTestVersion = "3.2.5"
  lazy val sprayJsonVersion = "1.3.6"
  lazy val typesafeConfigVersion = "1.4.1"

  val scalacticDependency = "org.scalactic" %% "scalactic" % scalaTestVersion
  val scalaTestDependency = "org.scalatest" %% "scalatest" % scalaTestVersion

  val rootDependencies = Seq(
      scalacticDependency % Test,
      scalaTestDependency % Test
  )

  val sprayJsonDependencies = Seq(
      "io.spray" %% "spray-json" % sprayJsonVersion
  )

  val typesafeConfigDependencies = Seq(
      "com.typesafe" % "config" % typesafeConfigVersion
  )

}
