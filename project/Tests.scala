import sbt.Keys.libraryDependencies
import sbt._

object Tests {
  val Dependencies = Seq(
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.1" % Test
    )
  )
}