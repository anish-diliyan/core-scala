package implicits

import scala.language.implicitConversions



object ImplicitsIntro extends App {
  // How this is compiled ??
  val pair = "Daniel" -> "555"
  val intPair = 1 -> 2
  /*
   * Their is no arrow -> method in String class or in Int class
   * -> is not available in any class.
   * -> is a method of implicit class "ArrowAssoc" that did Some Magic with our code
   * it turns the first argument in instance of ArrowAssoc class and then call the ->
   * on instance of ArrowAssoc with argument "555" and return the tuple ("Daniel", "555")
   */

  class Person(name: String) {
    def greet: String = s"Hi, I am $name"
  }

  //Advanced language feature: implicit conversion, import feature flag for implicit conversion
  // import scala.language.implicitConversions
  implicit def fromStringToPerson(str: String): Person = Person(str)

  // Although the greet is not a method of String class code should not compile and run
  // compiler will not give up after search for method in String class
  // It looks for all implicit classes, objects, values and methods that can help
  // That means it look for anything that can turn "anish" into something that has greet method
  // And it will find fromStringToPerson and rewrite as fromStringToPerson("anish").greet
  println("anish".greet)
  // Compiler assumes that their is only one implicit that matches, if we have multiple
  // then compilation error.
}
