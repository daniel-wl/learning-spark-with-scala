package com.daniel_wl

import org.apache.spark.sql.SparkSession

object Application {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder
      .appName("Spark-Test")
      .config("spark.master", "local")
      .config("spark.driver.memory", "")
      .getOrCreate();

    try {
      ReadSingleFile.run("/Users/daniel/Git/learning-scala/README.md", spark)
    } catch {
      case e: Exception => println(e.getMessage())
    }
  }
}
