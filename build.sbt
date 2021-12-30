import Dependencies._

ThisBuild / organization := "uk.org.aeb.sandbox"
ThisBuild / scalacOptions += ""
ThisBuild / scalaVersion := "2.13.5"
ThisBuild / version := "0.1"

lazy val root = (project in file("."))
  .aggregate(
    akkaBasic,
    playJson,
    sprayJson,
    typesafeConfig
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
    assembly / mainClass := Some(s"${organization.value}.akka.Main"),
    assembly / assemblyJarName := "akka-basic.jar"
  )

lazy val playJson = (project in file("play-json"))
  .settings(
      name := "play-json",
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

publishMavenStyle := true
