lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      scalaVersion := "2.13.3"
    )),
    name := "shoppingcart"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % Test
