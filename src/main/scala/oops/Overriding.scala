package oops

object Overriding extends App {
    // sealed class: restrict inheritance within this file only
    // final class: final class can not be inherited
    // final members: final members can not be override
    sealed class Animal {
      // we can not override final members
      final val isAlive = true
      val legs = 4;
      def eat() = "Grass"
    }
    class Cat(numberOfLegs: Int) extends Animal {
      override val legs: Int = numberOfLegs
      override def eat(): String = "Mouse"
    }
    class Dog(override val legs: Int)  extends  Animal {
      override def eat(): String = "Cat, Mouse"
    }
    val cat: Animal = Cat(4)
    println(cat.eat())
    val dog: Dog = Dog(4)
    println(dog.eat())
}
