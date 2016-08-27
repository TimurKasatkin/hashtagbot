packageArchetype.java_application

name := "hashtagbot"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += "jitpack" at "https://jitpack.io"

libraryDependencies += "com.github.mukel" % "telegrambot4s" % "v1.2.1"

mainClass in Compile := Some("HashTagBot")

    