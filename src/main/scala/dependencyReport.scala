import sbt._

object DependencyReport extends Plugin {
  lazy val dependencyReport = TaskKey[String]("dependency-report")

  dependencyReport <<= (externalDependencyClasspath in Compile, streams) map {
    (cp: Seq[Attributed[File]], streams) =>
       val report = cp.map {
         attributed =>
           attributed.get(Keys.moduleID.key) match {
             case Some(moduleId) => "%40s %20s %10s %10s".format(
               moduleId.organization,
               moduleId.name,
               moduleId.revision,
               moduleId.configurations.getOrElse("")
             )

             case None => // unmanaged JAR
               attributed.data.getAbsolutePath
           }
       }.mkString("\n")
     streams.log.info(report)
     report
  }
}
