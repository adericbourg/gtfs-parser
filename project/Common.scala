import sbt.Keys.{publishArtifact, _}
import sbt._


object  Common {
  val Settings: Seq[Def.Setting[_]] = Seq(
    organization := "net.dericbourg.gtfs-parser",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.12.2",
    crossScalaVersions := Seq("2.10.6", "2.11.8", scalaVersion.value),
    scalacOptions ++= Seq("-deprecation", "-unchecked")
  )

  val Logging = Seq(
    libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.25"
  )

  def scalaLogging(scalaVersion: String): ModuleID =
    if (scalaVersion.startsWith("2.10.")) { "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2" }
    else { "com.typesafe.scala-logging" %% "scala-logging" % "3.7.1" }

  val PublishMaven: Seq[Def.Setting[_]] = Seq(
    licenses := Seq("GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007" -> url("https://www.gnu.org/licenses/gpl-3.0.en.html")),
    homepage := Some(url("https://github.com/adericbourg/gtfs-parser")),
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := { _ => false },
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases" at nexus + "service/local/staging/deploy/maven2")
    },
    pomExtra := {
      <scm>
        <connection>scm:git:git@github.com:adericbourg/gtfs-parser.git</connection>
        <url>scm:git:git@github.com:adericbourg/gtfs-parser.git</url>
        <developerConnection>scm:git:git@github.com:adericbourg/gtfs-parser.git</developerConnection>
        <tag>HEAD</tag>
      </scm>
        <developers>
          <developer>
            <id>adericbourg</id>
            <name>Alban Dericbourg</name>
            <email>alban@dericbourg.net</email>
            <url>https://github.com/adericbourg</url>
          </developer>
        </developers>
    }
  )
}
