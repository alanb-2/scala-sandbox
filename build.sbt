import Dependencies._

ThisBuild / organization := "org.aeb.sandbox"
ThisBuild / scalacOptions += ""
ThisBuild / scalaVersion := "2.13.5"
ThisBuild / version := "0.1"

lazy val root = (project in file("."))
  .aggregate(sprayJson, typesafeConfig)
  .enablePlugins(JavaAppPackaging)
  .settings(
      name := "scala-sandbox",
      libraryDependencies ++= rootDependencies
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
