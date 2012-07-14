An sbt plugin to list all dependencies of an SBT project.

98% written by Jason Zaugg.

Cheerleading, documentation and 2% code by Mike Slinn.

Daily usage by millions.

## Installation

 1. Clone this project:
````
git clone git@github.com/mslinn/dependencyReport.git
````

 1. Compile and publish-local:
````
sbt compile publish-local
````

 1. Add this to your project's `project/plugins.sbt` (remember that file requires double-spacing):
````
addSbtPlugin("com.micronautics" % "dependencyreport" % "0.1.0-SNAPSHOT")
````

 1. This step adds the tasks defined in the plug-in to your SBT project.
    The new tasks are `compile:dependency-report` and `test:dependency-report`.
    Perform one of the following two steps.

    1. If your project has a top-level `build.sbt`, add the following line anywhere in that file (remember that file requires double-spacing):
````
com.micronautics.dependencyReport.DependencyReport.dependencyReportSettings
````

    1. If your project has a top-level `project/build.scala` (this file is not double-spaced):

        1. Look for the section starting with `object XXXX extends Build {`

        1. Add this line below it:
````
import com.micronautics.dependencyReport.DependencyReport._
````

        1. Look for the line(s) like this inside the same section: `lazy val YYYY = Project(`

        1. Do the following for each `Project` definition

            1. Concatenate the plug-in's tasks and settings with the project's other tasks and settings.
               The plug-in's tasks and settings are defined in `dependencyReportSettings`.
               The end result should look something like this:

````
lazy val YYYY = Project(
  id = "yyyy",
  base = file("."),
  settings = defaultSettings ++ dependencyReportSettings ++ Seq(libraryDependencies ++= Dependencies.yyyyDeps)
)
````

## Usage

Use this plug-in any of the following ways:

````
$ sbt dependency-report
$ sbt compile:dependency-report
$ sbt test:dependency-report
$ sbt
[info] Loading global plugins from /home/mslinn/.sbt/plugins
[info] Loading project definition from /work/myProject/project
[info] Set current project to myProject (in build file:/work/myProject/)
> dependency-report
````

## Sample Output
Output is sorted.

````
35 dependencies:
ch.qos.logback                      logback-classic                1.0.0
ch.qos.logback                      logback-core                   1.0.0
com.amazonaws                       aws-java-sdk                   1.1.8
com.google.protobuf                 protobuf-java                  2.4.1
com.novus                           salat-core_2.9.1               1.9.0
com.novus                           salat-util_2.9.1               1.9.0
com.thoughtworks.paranamer          paranamer                      2.4.1
com.typesafe.akka                   akka-actor                     2.0.1
commons-codec                       commons-codec                  1.6
commons-httpclient                  commons-httpclient             3.1
commons-io                          commons-io                     2.1
commons-logging                     commons-logging                1.1.1
javax.activation                    activation                     1.1
javax.mail                          mail                           1.4.5
joda-time                           joda-time                      1.6.2
net.liftweb                         lift-json_2.9.1                2.5-SNAPSHOT
org.apache.solr                     solr-solrj                     3.6.0
org.codehaus.jackson                jackson-core-asl               1.9.8
org.codehaus.woodstox               wstx-asl                       3.2.7
org.mongodb                         casbah-commons_2.9.1           2.4.1
org.mongodb                         casbah-core_2.9.1              2.4.1
org.mongodb                         casbah-gridfs_2.9.1            2.4.1
org.mongodb                         casbah-query_2.9.1             2.4.1
org.mongodb                         casbah-util_2.9.1              2.4.1
org.mongodb                         mongo-java-driver              2.8.0
org.scala-lang                      scala-compiler                 2.9.1
org.scala-lang                      scala-library                  2.9.1
org.scala-lang                      scalap                         2.9.1
org.scala-tools.time                time_2.9.1                     0.5
org.scalaj                          scalaj-collection_2.9.1        1.2
org.slf4j                           jcl-over-slf4j                 1.6.1
org.slf4j                           slf4j-api                      1.6.4
org.specs2                          specs2-scalaz-core_2.9.1       6.0.1
org.specs2                          specs2_2.9.1                   1.7.1
stax                                stax-api                       1.0.1
````
