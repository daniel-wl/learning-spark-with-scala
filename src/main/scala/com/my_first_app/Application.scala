package com.my_first_app

object Application extends App {
  override def main(args: Array[String]): Unit = {
    for (i <- 0 until args.length) {
      println(s"arg$i: ${args(i)}")
    }
  }
}
