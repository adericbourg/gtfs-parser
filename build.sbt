name := "gtfs-parser"

lazy val root = project.in(file("."))
  .settings(name := "gtfs-all")
  .settings(Common.Settings)
  .settings(Common.PublishMaven)
  .aggregate(core, api)
  .dependsOn(core, api)

lazy val core = (project in file("core"))
  .settings(name := "gtfs-core")
  .settings(Common.Settings)
  .settings(Common.PublishMaven)
  .settings(Tests.Dependencies)


lazy val api = (project in file("api"))
  .settings(name := "gtfs-api")
  .settings(Common.Settings)
  .settings(Common.PublishMaven)
  .dependsOn(core)
