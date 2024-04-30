package play_ground

import scala.annotation.tailrec

object HigherOrderFunction extends App {
  /*
   * write a function that will take three parameters
   * 1. A function f: Int => Int
   * 2. A value x
   * 3. A value n
   * apply "f" on "x" to "n" number of time
   */
  @tailrec
  def nTimes(f: Int => Int, x: Int, n: Int): Int = {
     if(n <= 1) f(x)
     else nTimes(f, f(x), n-1)
   }
   val adder: Int => Int = { x => x + 1 }
   //val nTimesResult = nTimes(adder, 10, 3)
   //println(nTimesResult)

   def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
     if(n <= 0) (x: Int) => x
     else (x: Int) => nTimesBetter(f, n-1)(f(x))
   }
   val plus10 = nTimesBetter(adder, 10)
   println(plus10(1))
}
