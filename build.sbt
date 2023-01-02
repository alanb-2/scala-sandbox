import Dependencies._

ThisBuild / organization := "uk.org.aeb.sandbox"
ThisBuild / scalacOptions ++= Seq("-deprecation")
ThisBuild / scalafmtOnCompile := true
ThisBuild / scalaVersion := "3.2.1"
ThisBuild / version := "0.1"

lazy val root = (project in file("."))
  .aggregate(
    akkaBasic,
    akkaParentChild,
    akkaState,
    playJson,
    sprayJson,
    typesafeConfig,
    zioConfig
  )
  .enablePlugins(JavaAppPackaging)
  .settings(
      name := "scala-sandbox",
      libraryDependencies ++= rootDependencies
  )

lazy val akkaBasic = (project in file("akka-basic"))
  .settings(
    name := "akka-basic",
    libraryDependencies ++= (rootDependencies ++ akkaDependencies),
    assembly / mainClass := Some(s"${organization.value}.akka.basic.Main"),
    assembly / assemblyJarName := "akka-basic.jar"
  )

lazy val akkaParentChild = (project in file("akka-parent-child"))
  .settings(
    name := "akka-parent-child",
    libraryDependencies ++= (rootDependencies ++ akkaDependencies),
    assembly / mainClass := Some(s"${organization.value}.akka.parentchild.Main"),
    assembly / assemblyJarName := "akka-parent-child.jar"
  )

lazy val akkaState = (project in file("akka-state"))
  .settings(
    name := "akka-state",
    libraryDependencies ++= (rootDependencies ++ akkaDependencies),
    assembly / mainClass := Some(s"${organization.value}.akka.state.Main"),
    assembly / assemblyJarName := "akka-state.jar"
  )

lazy val playJson = (project in file("play-json"))
  .settings(
      name := "play-json",
      scalafmtOnCompile := false,
      scalaVersion := "2.13.10",
      libraryDependencies ++= (rootDependencies ++ playJsonDependencies),
      assembly / assemblyMergeStrategy := {
        case x if x.endsWith("module-info.class") => MergeStrategy.discard
        case x =>
          val oldStrategy = (assembly / assemblyMergeStrategy).value
          oldStrategy(x)
      }
  )

lazy val sprayJson = (project in file("spray-json"))
  .settings(
      name := "spray-json",
      libraryDependencies ++= (rootDependencies ++ sprayJsonDependencies)
  )

lazy val typesafeConfig = (project in file("typesafe-config"))
  .settings(
      name := "typesafe-config",
      libraryDependencies ++= (rootDependencies ++ typesafeConfigDependencies)
  )

lazy val zioConfig = (project in file("zio-config"))
.settings(
  name := "zio-config",
  libraryDependencies ++= (zioDependencies ++ zioTestDependencies)
)

publishMavenStyle := true
