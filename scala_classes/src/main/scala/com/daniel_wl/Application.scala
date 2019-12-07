package com.daniel_wl

object Application extends App {
  override def main(args: Array[String]): Unit = {
    //create instances of classes with the "new" operator
    val basicClass = new BasicClass("foo", "bar")

    //named arguments are supported
    val basicClass2 = new BasicClass(bar = "bar", foo = "foo")

  }
}
