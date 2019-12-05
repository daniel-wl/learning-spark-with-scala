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
      val pathToReadme = "/Users/daniel/Git/learning-scala/README.md"
      val logData = spark.read.textFile(pathToReadme).cache()
      val numberOfLetterAs = logData.filter(line => line.contains('a')).count()
      val numberOfLetterBs = logData.filter(line => line.contains('b')).count()

      println(s"Spark version: ${spark.version}")
      println(
        s"Lines with a: $numberOfLetterAs, Lines with b: $numberOfLetterBs"
      )

      spark.stop()
    } catch {
      case e: Exception => println(e.getMessage())
    }
  }
}
