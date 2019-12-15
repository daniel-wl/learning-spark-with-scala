package com.daniel_wl
import org.apache.spark.sql.SparkSession

object ReadSingleFile {
  def run(file: String) {
    val spark: SparkSession = SparkSession.builder
      .appName("Spark-Test")
      .config("spark.master", "local[4]")
      .getOrCreate();

    val logData = spark.read.textFile(file).cache()
    val numberOfLetterAs = logData.filter(line => line.contains('a')).count()
    val numberOfLetterBs = logData.filter(line => line.contains('b')).count()

    println(s"Spark version: ${spark.version}")
    println(
      s"Lines with a: $numberOfLetterAs, Lines with b: $numberOfLetterBs"
    )
  }
}
