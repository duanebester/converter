import Dependencies._

ThisBuild / scalaVersion := "2.13.1"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "converter",
    libraryDependencies += scalaTest % Test
  )

assemblyJarName in assembly := "converter.jar"
mainClass in assembly := Some("converter.Converter")
