ThisBuild / scalaVersion := "2.11.12"

lazy val hello_world = project
  .in(file("hello_world"))
  .settings(
    name := "hello-world-with-scala",
    version := "0.1"
  )

lazy val spark = project
  .in(file("spark"))
  .settings(
    name := "learning-spark-with-scala",
    version := "0.1",
    libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.4"
  )
