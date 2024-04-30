package oops

object AbstractDataType extends App {

  abstract class Animal {
    val category: String
    def eat(): String
    def getLegs: Int = 4
  }
  class Dog(override val category: String) extends Animal {
    override def eat(): String = "Mouse, Cat"
    override def getLegs: Int = super.getLegs
  }

}
