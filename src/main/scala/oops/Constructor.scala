package oops

object Constructor extends App {
    class Person(name: String) {
      println(s"HI, I am $name and I am Person ")
    }
    class Adult(name: String, age: Int) extends Person(name){
      println(s"HI, I am $name and I am Adult of $age year old")
    }
    //HI, I am bob and I am Person
    //HI, I am bob and I am Adult of 21 year old
    new Adult("bob", 21)
}
