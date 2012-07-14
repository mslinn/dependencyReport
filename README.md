An sbt plugin to list all dependencies of an SBT project.

98% written by Jason Zaugg.

Cheerleading, documentation and 2% code by Mike Slinn.

Daily usage by millions.

## Usage

 1. Clone this project:
````
git clone git@github.com:mslinn/dependencyReport.git
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

    1. If your project has a top-level `build.sbt`, add this anywhere in that file (remember that file requires double-spacing):
````
com.micronautics.dependencyReport.DependencyReport.dependencyReportSettings
````

    1. If your project has a top-level `project/build.scala`:

        1. Look for the section starting with:
````
object XXXX extends Build {
````

        1. Add this line below it:
````
import com.micronautics.dependencyReport.DependencyReport._
````

        1. Look for the line like this inside the same section:
````
lazy val YYYY = Project(
````

        1. Concatenate the plug-in's tasks and settings with the project's other tasks and settings.
           The plug-in's tasks and settings are defined in `dependencyReportSettings`.
           The end result should look something like this:

        lazy val YYYY = Project(
          id = "yyyy",
          base = file("."),
          settings = defaultSettings ++ dependencyReportSettings ++ Seq(libraryDependencies ++= Dependencies.yyyyDeps)
        )

 1. Use the plug-in any of these ways:
````
$ sbt dependency-report
$ sbt compile:dependency-report
$ sbt test:dependency-report
$ sbt
[info] Loading global plugins from /home\mslinn/.sbt/plugins
[info] Loading project definition from /work/myProject/project
[info] Set current project to myProject (in build file:/work/myProject/)
> dependency-report
````

## Sample Output

````
11 dependencies:
org.scala-lang                           scala-library        2.9.1-1
com.typesafe.akka                        akka-actor           2.0.1
com.typesafe.akka                        akka-agent           2.0.1
org.scala-tools                          scala-stm_2.9.1      0.5
com.github.scala-incubator.io            scala-io-core_2.9.1  0.3.0
com.github.jsuereth.scala-arm            scala-arm_2.9.1      1.1
com.github.scala-incubator.io            scala-io-file_2.9.1  0.3.0
org.apache.httpcomponents                httpclient           4.1.2
org.apache.httpcomponents                httpcore             4.1.2
commons-logging                          commons-logging      1.1.1
commons-codec                            commons-codec        1.4
````
