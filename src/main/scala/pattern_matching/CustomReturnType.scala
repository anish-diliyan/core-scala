package pattern_matching

import scala.runtime.Nothing$

object CustomReturnType extends App {
  class Person(val name: String, val age: Int)

  abstract class MyOption[A] {
    def isEmpty: Boolean
    def get: A
  }

  object Person {
    def unapply(person: Person): MyOption[(String, Int)] = new MyOption[(String, Int)] {
      override def isEmpty: Boolean = false
      override def get: (String, Int) = (person.name, person.age)
    }
  }

  val bob = new Person("bob", 25)
  val result = bob match {
    case Person(n, a) => s"Hi, I am $n and $a year old !"
  }
  println(result)

  val zombiePerson: Person = null
  val result2 = zombiePerson match {
    case Person(n, a) =>  s"Hi, I am $n and $a year old !"
    case _ => "Hi, I am zombie person !!!!"
  }
  println(result2)
}
