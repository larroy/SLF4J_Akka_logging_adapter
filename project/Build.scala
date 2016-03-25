import sbt._
import Keys._

object Slf4jAkkaAdapterBuild extends Build {
  val publishUser = "SONATYPE_USER"
  val publishPass = "SONATYPE_PASS"

  val currVersion = "0.1"
  val userPass = for {
    user <- sys.env.get(publishUser)
    pass <- sys.env.get(publishPass)
  } yield (user, pass)

  val publishCreds: Seq[Setting[_]] = Seq(userPass match {
    case Some((user, pass)) =>
      credentials += Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", user, pass)
    case None =>
      // prevent publishing
      publish <<= streams.map(_.log.info("Publishing to Sonatype is disabled since the \"" + publishUser + "\" and/or \"" + publishPass + "\" environment variables are not set."))
  })


  val commonSettings = Defaults.defaultSettings ++ publishCreds ++ Seq( 
    name := "Slf4jAkkaAdapter",
    organization := "com.larroy",
    version := currVersion, 
    scalaVersion := "2.11.7",
    libraryDependencies ++= Seq(
     "ch.qos.logback" % "logback-classic" % "1.1.6",
     "org.slf4j" % "slf4j-api" % "1.7.19",
     "com.typesafe.akka" %% "akka-actor" % "2.4.2",
     "com.typesafe.akka" %% "akka-slf4j" % "2.4.2",
     "org.scalatest" %% "scalatest" % "2.2.6" % "test",
     "com.typesafe.akka" %% "akka-testkit" % "2.4.2" % "test"
    ),
    resolvers += Resolver.sonatypeRepo("public")
  )

  val mainProject = Project(
    id = "Slf4jAkkaAdapter",
    base = file("."),
    settings = commonSettings
  )
}
