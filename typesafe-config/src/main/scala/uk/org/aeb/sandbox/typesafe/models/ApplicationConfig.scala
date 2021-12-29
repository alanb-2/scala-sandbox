package uk.org.aeb.sandbox.typesafe.models

import com.typesafe.config.{Config, ConfigFactory}

import scala.jdk.CollectionConverters._

case class ApplicationConfig(name: String, age: Int, hobbies: Seq[String])

object ApplicationConfig {

  def apply(application: Config,
            reference: Config = ConfigFactory.defaultReference()
  ): ApplicationConfig = {

    application.checkValid(reference, "app")

    ApplicationConfig(
        name = application.getString("app.name"),
        age = application.getInt("app.age"),
        hobbies = application.getStringList("app.hobbies").asScala.toList
    )

  }

}
