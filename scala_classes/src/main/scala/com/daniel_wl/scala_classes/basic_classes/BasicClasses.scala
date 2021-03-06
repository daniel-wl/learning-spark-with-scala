package com.daniel_wl.scala_classes.basic_classes

/*
The "argument list" for a class is actually the constructor argument list,
and the "body" of the class is the constructor.
 */
class BasicClass(foo: String, bar: String) {
  val Foo = foo
  val Bar = bar

  //weirdly, method declarations go in the constructor
  def bat: String = {
    foo + bar
  }

  //everything is public by default
  def publicMethod(parameter: String): Unit = {
    println("parameter")
  }

  val PublicMember: String = "public string member"

  //private is like private in other languages
  private def privateMethod: String = {
    "Nobody can see this"
  }

  private val PrivateMember: String = "private string member"

  //protected is also similar
  protected def protectedMethod = "protected method"
  protected val ProtectedMember = "protected string member"
}
