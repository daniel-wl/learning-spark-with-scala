package com.daniel_wl

object Hello_World extends App {
  override def main(args: Array[String]): Unit = {
    println("Hello, World!")
    for (i <- 0 until args.length) {
      println(s"arg$i: ${args(i)}")
    }
  }
}
