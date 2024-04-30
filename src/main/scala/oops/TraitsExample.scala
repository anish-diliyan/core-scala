package oops

object TraitsExample extends App {
  abstract class A:
    val message: String

  class B extends A:
    val message = "I'm an instance of class B"

  trait C extends A:
    def loudMessage: String = message.toUpperCase()

  trait D extends A:
    def varyLoudMessage: String = message.toUpperCase.replace(" ", "_")

  class E extends B, C, D

  val e: E = E()
  println(e.message) // I'm an instance of class B
  println(e.loudMessage) // I'M AN INSTANCE OF CLASS B
  println(e.varyLoudMessage) // I'M_AN_INSTANCE_OF_CLASS_B
}
