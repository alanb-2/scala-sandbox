import Dependencies._

ThisBuild / organization := "org.aeb.uk.sandbox"
ThisBuild / scalacOptions += ""
ThisBuild / scalaVersion := "2.13.5"
ThisBuild / version := "0.1"

lazy val root = (project in file("."))
  .aggregate(playJson, sprayJson, typesafeConfig)
  .enablePlugins(JavaAppPackaging)
  .settings(
      name := "scala-sandbox",
      libraryDependencies ++= rootDependencies
  )

lazy val playJson = (project in file("play-json"))
  .settings(
      name := "play-json",
      libraryDependencies ++= (rootDependencies ++ playJsonDependencies)
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
