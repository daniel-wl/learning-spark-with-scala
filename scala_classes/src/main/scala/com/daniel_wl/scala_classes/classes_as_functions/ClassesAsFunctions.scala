package com.daniel_wl.scala_classes.classes_as_functions

class Adder(amount: Int) {
  def add(amountToAdd: Int): Int = {
    amount + amountToAdd
  }

  def apply(amountToAdd: Int): Int = {
    add(amountToAdd)
  }
}
