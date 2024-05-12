package fp.lambda

object E1Exercise extends App {
 /*
  * 1. A function which takes two String and concatenate them
  * 2. transform MyPredicate and MyTransformer into function types
  * 3. Define a function which takes Int and return an another function
  *    --- which takes Int and return Int.
  *    --- what is type of the function
  */
  def stringConcatenate = new Function2[String, String, String]{
    override def apply(v1: String, v2: String): String = v1 + " " + v2
  }
  println(stringConcatenate("Anish", "Kumar"))

  def superAdder = new Function1[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }
  val adder = superAdder(3)
  val result = adder(4)
  println(result)
  println(superAdder(3)(4))
}
