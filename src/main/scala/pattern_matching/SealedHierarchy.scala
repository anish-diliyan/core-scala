package pattern_matching

object SealedHierarchy extends App {

  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")

  // Warning: match may not be exhaustive. because i do not cover the Animal of type Parrot
  // But if Animal is not sealed, warning not come. So actually Sealed classes force you
  // to match every possible patterns
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
  }

}
