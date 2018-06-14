name := "listperf"

organization := "consulting.hindsight"

version := "1.0.0-SNAPSHOT"

libraryDependencies += "com.storm-enroute" %% "scalameter" % "0.8.2"

testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")

