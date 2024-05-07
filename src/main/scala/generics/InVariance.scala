package generics

object InVariance extends App {
  class BiggerBox[A](box: A)
  class SmallerBox[A](box: A) extends BiggerBox(box)
  /*
   * Error:
   * Found: BiggerBox[Cat] Required: BiggerBox[Animal]
   * Conclusion: We can put Cat inside Box of Animal (it does not matter Cat is an Animal)
   * val notValidBox: BiggerBox[Animal] = new BiggerBox[Cat](Cat("tilo"))
   */
  val bb: BiggerBox[Cat] = new BiggerBox[Cat](Cat("morris"))
  /*
   * Bigger Box of Cat can be replaced with SmallerBox of Cat
   */
  val sb: BiggerBox[Cat] = new SmallerBox[Cat](Cat("Milo"))

}
