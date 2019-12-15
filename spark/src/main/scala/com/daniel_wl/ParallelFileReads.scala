package com.daniel_wl
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object ParallelFileReads {
  def run(files: Array[String]) {
    val sc: SparkContext = SparkSession.builder
      .appName("Spark-Test")
      .config("spark.master", "local[4]")
      .getOrCreate()
      .sparkContext

    val numLines = sc
      .parallelize(files)
      .aggregate(0.toLong)(
        (
            (
                acc,
                value
            ) => {
              println(s"acc: $acc | value: $value")
              val spark: SparkSession = SparkSession.builder
                .appName("Spark-Test")
                .config("spark.master", "local[4]")
                .getOrCreate();
              println(s"spark: $spark")
              println(s"spark.read: ${spark.read}")

              val df = spark.read.text(value)
              println(s"df: $df")
              val lines = df.count
              println(s"lines: $lines")
              acc + lines
            }
        ),
        (
            (
                acc1,
                acc2
            ) => {
              println(s"acc1: $acc1 | acc2: $acc2")
              acc1 + acc2
            }
        )
      )

    println("######################")
    println(s"Total lines: $numLines")
    println("######################")
  }
}
