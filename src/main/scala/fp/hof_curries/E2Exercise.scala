package fp.hof_curries

object E2Exercise extends App {
   def compose(double: Int => Int, square: Int => Int) =
     (x: Int) => square(double(x))

   val double = (x: Int) => x * 2
   val square = (x: Int) => x * x

   val composeResult = compose(double, square)
   print(composeResult(10)) // 10 * 2 = 20 * 20 = 400
}
