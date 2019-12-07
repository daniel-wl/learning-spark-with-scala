package com.daniel_wl.classes_as_functions

class Adder(amount: Int) {
  def add(amountToAdd: Int): Int = {
    amount + amountToAdd
  }

  def apply(amountToAdd: Int): Int = {
    add(amountToAdd)
  }
}

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
