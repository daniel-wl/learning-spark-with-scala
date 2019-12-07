package com.daniel_wl.scala_classes.companion_objects

import java.sql.Time
import java.util.Date

// A basic class with a single member and a constructor
class Timestamp(seconds: Long) {
  val Seconds = seconds
}

//companion objects define an apply method that we can use to call the object like a function.
//this way we can define additional ways of creating the Timestamp class.
//in other languages we might use overloaded constructors for this
object Timestamp {
  def apply(hours: Int, minutes: Int, seconds: Int): Timestamp = {
    new Timestamp(hours * 60 * 60 + minutes * 60 + seconds)
  }

  //we can also define static methods
  def toDate(timestamp: Timestamp): Date = {
    new Date(2019, 12, 7, 0, 0, timestamp.Seconds.toInt)
  }
}
