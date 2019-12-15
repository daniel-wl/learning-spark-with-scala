package com.daniel_wl

import org.apache.spark.sql.SparkSession

object Application {
  def main(args: Array[String]): Unit = {
    println("Starting application.")
    println(s"Command line args: ${args.mkString(",")}")
    try {
      args(0) match {
        case "read-single-file" => {
          val file = args(1)
          println(s"Reading file $file")
          ReadSingleFile.run(file)
        }
        case "parallel-file-reads" => {
          val files = args.takeRight(args.length - 1)
          println(s"Reading files ${files.mkString(",")} in parallel")
          ParallelFileReads.run(files)
        }
        case _ => println(s"Unknown argument.")
      }
    } catch {
      case e: Exception => {
        println(s"Caught exception ${e.getClass.getName}: ${e.getMessage()}")
      }
    }
  }
}
