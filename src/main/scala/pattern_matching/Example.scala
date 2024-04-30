package pattern_matching

import scala.util.Random

/*
* cases are matched in order
* If nothing is matched, then MatchError. to resolve this add default case
* return Type? Unified type of all cases
* */
object Example extends App {
  // use pm like switch (match on value)
  val random = new Random().nextInt(10)
  val result = random match {
    case 1 => "This is 1"
    case 2 =>  "This is 2"
    case  _ => "This is default"
  }
  println(result)

  // use pm on case classes using pattern of case class
  case class Person (name: String, age: Int)
  val person = Person("Anish", 30)
  person match {
    case Person(name, age) if age > 30 => "I amd greater thn 30"
    case Person(name, age) => s"Hi i am $name and $age year old"
    case null => "This is default handling"
  }

  // pm on sealed hierarchy
  sealed class Animal
  case class Dog(name: String) extends Animal
  case class Parrot(name: String, greeting: String) extends Animal
  val animal: Animal = Dog("Dugu")
  val sealedResult = animal match {
    case Dog(name) => s"Hi, I am Dog and name = $name"
    case Parrot(name, greeting) => s"Hi i am $name and $greeting"
  }
  println(sealedResult)

  // extracting head and tail from list
  val aStandardList = List(1, 2, 3, 42)
  aStandardList match {
    case head :: tail => println(s"head = $head and tail = $tail")
    case Nil => "Will match with empty list"
  }
  // apply match on elements of list
  val astandardListResult = aStandardList.map { x =>
    x match {
      case v if v % 2 == 0 => s"$v is even"
      case v if v % 2 != 0 => s"$v is odd"
    }
  }
  println(astandardListResult)
  // same way to write above
  val astandardListResult2 = aStandardList.map {
    case v if v % 2 == 0 => s"$v is even"
    case v if v % 2 != 0 => s"$v is odd"
  }
  println(astandardListResult2)
}
