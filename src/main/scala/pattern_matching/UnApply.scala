package pattern_matching

object UnApply extends App {
  val c: Char = 65535
  class Person(val name: String, val age: Int)

  // Name this as Person recommended to keep in sync with Person (Not Mandatory)
  object PersonPattern {
    def unapply(person: Person): Option[(String, Int)] = {
      val nameAndAge = (person.name, person.age)
      Some(nameAndAge)
    }
    def unapply(age: Int): Option[String] = {
      if(age < 21) Some("minor") else Some("major")
    }

    def unapply(name: String): Boolean = {
      if(name.startsWith("b")) true else false
    }
  }

  val bob: Person = new Person("bob", 25)
  // Here match will call PersonPattern.unapply(person: Person) and return value
  // value will be returned if and only if unapply returning Option.
  val greeting = bob match {
    // collect the return value here in value
    // Note:- here value is a tuple so it can also be collected in n, a
    case PersonPattern(value) => s"Hi, I am ${value._1}, and I am ${value._2} year old."
  }
  println(greeting)
  val legalStatus = bob.age match {
    // here match will call PersonPattern.unapply(age: Int)
    // get the returned value in status
    case PersonPattern(status) => s"My status is $status"
  }
  println(legalStatus)

  val nameStartWithB = bob.name match {
    // here match will call PersonPattern.unapply(name: String)
    // and unapply is not returning Option so it will not return value
    case PersonPattern() => "Not getting value from unapply"
  }
  println(nameStartWithB)
}
