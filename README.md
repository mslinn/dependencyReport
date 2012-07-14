An sbt plugin to list all dependencies of an SBT project.

99.9% written by Jason Zaugg.

Cheerleading and 1% code by Mike Slinn.

Daily usage by millions.

## Usage

 1. Clone this project:

````
git clone git@github.com:mslinn/dependencyReport.git
````

 2. Compile and publish-local:

````
sbt compile publish-local
````

 3. Add this to your project's `project/plugins.sbt`:
````
addSbtPlugin("com.micronautics" % "dependencyReport" % "0.1.0-SNAPSHOT")
````

 4. Add this setting to your project's `build.sbt`:

````
com.micronautics.dependencyReport.DependencyReport.dependencyReportSettings
````

This adds the tasks `compile:dependency-report` and `test:dependency-report`.

Use the plug-in this way:

````
sbt compile:dependency-report
````
