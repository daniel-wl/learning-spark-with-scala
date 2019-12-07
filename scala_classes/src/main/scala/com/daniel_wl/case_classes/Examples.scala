package com.daniel_wl.case_classes

object Examples {
  def equalityExample = {
    val person1 = new Person("John", "Doe")
    val person2 = new Person("Jane", "Doe")
    val person3 = new Person("Jane", "Doe")

    person1.equals(person2) //false
    person2.equals(person2) //true
    person2.equals(person3) //true

    //the == operator is shorthand for .equals, so the behaviour is the same
    person1 == person2 //false
    person2 == person2 //true
    person2 == person3 //true

    person1.eq(person1) //true
    person1.eq(person2) //false
    person2.eq(person3) //false
  }

  def boilerplateExample = {
    val person = new Person("Jane", "Doe")
    //free members:
    person.firstName
    person.lastName

    //free companion object. Note omission of "new" operator
    val person2 = Person("John", "Doe")

    //sensible toString overload
    person2.toString() //prints "Person(John,Doe)"
  }

  def hashCodeExample = {
    val person1 = new Person("John", "Doe")
    val person2 = new Person("Jane", "Doe")
    val person3 = new Person("Jane", "Doe")

    person1.hashCode //148660653
    person2.hashCode //-744869950
    person3.hashCode //-744869950
  }

  def copyExample = {
    val person1 = new Person("Jane", "Doe")
    val person2 = person1.copy(firstName = "John")
    person2.toString //prints "Person(John,Doe)"
  }

  def patternMatchingExample = {
    val person = new Person("John", "Doe")

    person match {
      case Person("Jane", "Doe") => "Matched Jane Doe" //no match
      case Person("John", "Deo") => "Matched John Deo" //no match
      case Person("John", "Doe") => "Matched John Doe" //match!
      case _                     => throw new RuntimeException(s"${person.toString} not found.")
    }

    //different patterns to match on
    val firstName = "Jane"
    val lastName = "Johnson"
    person match {
      case Person("John", _)     => "Matches anyone with first name \"John\""
      case Person("John", "Doe") => "Matches John Doe specifically"
      case Person(firstName, lastName) =>
        "Matches Persons with firstName and lastName"
    }
  }
}
