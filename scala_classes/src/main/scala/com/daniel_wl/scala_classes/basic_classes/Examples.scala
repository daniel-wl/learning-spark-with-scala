package com.daniel_wl.scala_classes.basic_classes

object Examples {
  def Example: Unit = {
    //create instances of classes with the "new" operator
    val basicClass = new BasicClass("foo", "bar")

    //named arguments are supported
    val basicClass2 = new BasicClass(bar = "bar", foo = "foo")
  }
}
