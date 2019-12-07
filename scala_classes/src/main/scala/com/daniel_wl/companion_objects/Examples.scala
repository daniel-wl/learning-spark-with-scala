package com.daniel_wl.companion_objects

object Examples {
  def Example {
    //we can create a timestamp with the normal constructor
    val timestamp: Timestamp = new Timestamp(120)

    //or we can use the companion object to access our other constructors
    val timestamp2: Timestamp = Timestamp(hours = 0, minutes = 2, seconds = 0)

    timestamp2.Seconds == timestamp.Seconds
  }
}
