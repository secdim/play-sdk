name := "app"
organization := "com.secdim"
version := "1.0.0"
scalaVersion := "2.13.14"

// Mirrors the Java harness's `test.java.srcDir "test"`: tests live in
// <root>/test/scala, not the sbt-default src/test/scala.
Test / unmanagedSourceDirectories += baseDirectory.value / "test" / "scala"

// scalatest-funsuite alone (not the full scalatest umbrella) keeps the
// dependency tree minimal -- it pulls in only scalatest-core + its Tag support.
libraryDependencies += "org.scalatest" %% "scalatest-funsuite" % "3.2.19" % Test

Compile / mainClass := Some("app.Main")
