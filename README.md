An sbt plugin to list all dependencies of an SBT project.

99.9% written by Jason Zaugg.

Cheerleading and 1% code by Mike Slinn.

Daily usage by millions.

## Usage

Add setting to your project:

    com.micronautics.dependencyReport.DependencyReport.dependencyReportSettings

This adds the tasks `compile:dependency-report` and `test:dependency-report`.