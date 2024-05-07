package generics

abstract class Animal {
  def name: String
}

abstract class Pet extends Animal

case class Cat(name: String) extends Pet
case class Dog(name: String) extends Pet