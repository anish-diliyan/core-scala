package fp.hof_curries

object E1Exercise extends App {
  /*
   * Write a function with three parameter:
   * f: Int => Int
   * number: Int
   * counter: Int
   * Apply f on number for counter number of times
   */
   def multiplier(f: Int => Int, counter: Int,  number: Int): Int = {
     if(counter <= 0) number
     else f(number) * multiplier(f, counter - 1, number)
   }
   def doubler = (x: Int) => x * 2
   // 20 * multiplier(doubler, 1, 10)
   //      20 * multiplier(doubler, 0, 10)
   //           10
   println(multiplier(doubler, 2, 10))
}
