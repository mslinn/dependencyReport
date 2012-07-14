An sbt plugin to list all dependencies of an SBT project.

99.9% written by Jason Zaugg.

Cheerleading and 1% code by Mike Slinn.

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

 1. Add this to your project's `project/plugins.sbt`:
````
addSbtPlugin("com.micronautics" % "dependencyReport" % "0.1.0-SNAPSHOT")
````

 1. Add this setting to your project's `build.sbt`:
````
com.micronautics.dependencyReport.DependencyReport.dependencyReportSettings
````
This adds the tasks `compile:dependency-report` and `test:dependency-report`.

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
sbt dependency-report
[info]                           org.scala-lang        scala-library      2.9.2
[info]                               org.scalaz    scalaz-core_2.9.1      6.0.3
[info]                         com.google.guava                guava     11.0.2
[info]                 com.google.code.findbugs               jsr305      1.3.9
[info]                                 fastutil             fastutil      5.1.5
[info]                                joda-time            joda-time        1.6
[info]                                org.slf4j            slf4j-api      1.6.4
[info]                           ch.qos.logback      logback-classic      1.0.2
[info]                           ch.qos.logback         logback-core      1.0.2
[info]                                org.sat4j       org.sat4j.core      2.3.1
[info]                        com.efgfp.commons       spring-wrapper       0.18
[info]                        com.efgfp.commons     efg-commons-lang        0.5
[info]                      org.springframework          spring-core      2.5.6
[info]                          commons-logging      commons-logging      1.1.1
[info]                             commons-lang         commons-lang        2.4
[info]                               commons-io           commons-io        1.4
````