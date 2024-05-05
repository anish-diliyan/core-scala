package pattern_matching

object DecomposeValues extends App {
  // specially used in conjunction with case classes
  // case classes has the ability to deconstructed or extracted in pattern matching
  case class Person(name: String, age: Int)
  val bob = Person("bob", 20)

  val greeting = bob match {
    // instead of providing value, I am providing the pattern
    // if bob is a Person, this pattern match expression able to extract bob
    // in to its constituent parts (name: String, age: Int)
    // Note: we can also run guards with if condition to match the pattern with condition
    case Person(n , a) if a < 21 => s"Hi, My name is $n and i can not drink"
    case Person(n , a) => s"Hi, My name is $n and i am $a years old"
    case null => "I do not know, who i am ?"
  }
  println(greeting)
}
