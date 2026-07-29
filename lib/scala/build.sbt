name := "app"
organization := "com.secdim"
version := "1.0.0"
scalaVersion := "2.13.14"

// scalatest-funsuite alone (not the full scalatest umbrella) keeps the
// dependency tree minimal -- it pulls in only scalatest-core + its Tag support.
libraryDependencies += "org.scalatest" %% "scalatest-funsuite" % "3.2.19" % Test

Compile / mainClass := Some("app.Main")
