import Dependencies._

ThisBuild / organization := "org.aeb.sandbox"
ThisBuild / scalacOptions += ""
ThisBuild / scalaVersion := "2.13.5"
ThisBuild / version := "0.1"

lazy val root = (project in file("."))
  .aggregate(sprayJson)
  .enablePlugins(JavaAppPackaging)
  .settings(
      name := "scala-sandbox",
      libraryDependencies ++= rootDependencies,
      test in assembly := {}
  )

lazy val sprayJson = (project in file("spray-json"))
  .settings(
      name := "spray-json",
      libraryDependencies ++= (rootDependencies ++ sprayJsonDependencies)
  )
