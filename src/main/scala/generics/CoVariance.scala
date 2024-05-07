package generics


object CoVariance extends App {
  class BiggerBox[+A](box: A)
  class SmallerBox[A](box: A) extends BiggerBox(box)

  val bb: BiggerBox[Cat] = new BiggerBox[Cat](Cat("morris"))
  val sb: BiggerBox[Cat] = new SmallerBox[Cat](Cat("Milo"))
  // Animal can be replace by Cat
  // Parent content type can be replaced with child content type
  val notValidBox: BiggerBox[Animal] = new BiggerBox[Cat](Cat("tilo"))
}
