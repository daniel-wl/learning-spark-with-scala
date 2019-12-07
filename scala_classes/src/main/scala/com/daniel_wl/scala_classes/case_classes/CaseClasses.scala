package com.daniel_wl.scala_classes.case_classes

case class Person(firstName: String, lastName: String) {
  def fullName = s"$firstName $lastName"
}
