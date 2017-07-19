name := "gtfs-parser"

lazy val root = project.in(file("."))
  .settings(name := "gtfs-parser")
  .settings(Common.Settings)
  .settings(Common.PublishMaven)
  .aggregate(api)

lazy val api = (project in file("api"))
  .settings(name := "gtfs-parser-api")
  .settings(Common.Settings)
  .settings(Common.PublishMaven)
