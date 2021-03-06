# Classes in scala
The fundamental idea of a class as a template from which to create objects with similar properties remains in scala, but there are a few additional things you can do with them.
## Classes as templates for objects
Classes are pretty straightforward when used as templates for objects. Most of the behaviour and functionality is similar to what would be found in other object-oriented languages
## Classes as functions
Classes that have a method called `apply` can be treated as functions. This forms the basis of functional programming in scala.
## Companion objects
Companion objects are "classes-as-functions" that are also static objects. They have the same name as another class. We can use them to define additional ways of constructing the classes that they "belong" to. In other languages we might use constructor overloads to do this. Additionally we can use companion objects to define additional methods on the class. This is like defining static methods in java. Companion objects must have the same names as the class they belong to. This doesn't cause a naming conflict because an `object` is a value in scala and a `class` is a type, and in scala types and values have separate namespaces. Companion objects must be defined in the same file as the class they belong to. When typing on the interactive scala console, you have to use the `:paste` command to enter the class and companion object as one
## Case classes
Case classes allow you to define a class, a companion object, and a lot of boilerplate all at once. With case classes we get:
1. A field for every constructor argument.
2. A toString overload that prints a friendly string representation of the type
3. An overload of the `equals` method that allows us to compare objects by **value** instead of by reference. We can still use the `eq` method to compare by reference.
4. An overload of the `hashCode` method that operates on the members of the class.
5. A `copy` method that creates a new object with the same field values as the current object. The `copy` method allows us to provide optional arguments for field values that we want to override.
6. Implementations of `java.io.Serializable` and `scala.Product`.
7. Code to implement an extractor pattern for use in pattern matching.
There are also **case objects** which get us a lot of the same free boilerplate, but for a static object instead
