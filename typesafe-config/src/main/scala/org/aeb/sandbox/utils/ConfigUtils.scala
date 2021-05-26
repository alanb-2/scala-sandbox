package org.aeb.sandbox.utils

import com.typesafe.config.{Config, ConfigFactory}

import scala.collection.mutable.ArrayBuffer

object ConfigUtils {

  def getKeys(configuration: Config, keyPath: String): Array[String] = {

    val keys = ArrayBuffer[String]()
    configuration.getObject(keyPath).forEach { case (k, _) =>
      keys += k
    }

    keys.toArray

  }

}
