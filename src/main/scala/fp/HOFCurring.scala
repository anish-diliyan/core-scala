package fp

import scala.annotation.tailrec

object HOFCurring extends App {
  // define a function, that applies f (Int => Int), n times over x
  @tailrec
  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if(n <= 0) x
    else nTimes(f, n-1, f(x))
  }
  val doubler = (x: Int) => x * 2
  val result = nTimes(doubler, 2, 3)
  println(result) // 12
  // 1. f(3) = 6, 2. f(6) = 12

  def nTimesBetter(f: Int => Int, n: Int): Int => Int = {
    if(n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))
  }

  val plusTen = nTimesBetter(doubler, 2)
  val result1 = plusTen(3)
  println(result1) // 12

  // curried function
  // supper adder is a function which takes Int and return Int => Int
  val superAdder: Int => Int => Int = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3)
  println(add3(10)) // 13
  println(superAdder(3)(10)) // 13

  // function with multiple parameter list to act like curried function
  def curriedFormater(s: String)(d: Double): String = s.format(d)
  // Here type is mandatory
  val standardFormatter: Double => String = curriedFormater("%4.2f")
  val preciseFormat: Double => String = curriedFormater("%10.8f")
  println(standardFormatter(Math.PI)) // 3.14
  println(preciseFormat(Math.PI)) // 3.14159265
}
