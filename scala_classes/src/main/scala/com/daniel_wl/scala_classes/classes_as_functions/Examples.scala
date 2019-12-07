package com.daniel_wl.scala_classes.classes_as_functions

object Examples {
  def classesAsObjects: Unit = {
    val adder = new Adder(10)
    //we can call the "add" method directly
    val addedAmount = adder.add(10)
  }

  def classesAsFunctions: Unit = {
    val adder = new Adder(10)
    //or we can treat the instance as a method
    val addedAmount = adder(10)

    //or we can call the apply method directly.
    //This is equivalent to the above call
    val addedAmount2 = adder.apply(10)
  }
}
