package com.daniel_wl.scala_classes.companion_objects

import java.{util => ju}

object Examples {
  def Example {
    //we can create a timestamp with the normal constructor
    val timestamp: Timestamp = new Timestamp(120)

    //or we can use the companion object to access our other constructors
    val timestamp2: Timestamp = Timestamp(hours = 0, minutes = 2, seconds = 0)

    timestamp2.Seconds == timestamp.Seconds

    //access static members
    val date: ju.Date = Timestamp.toDate(timestamp)
  }
}
