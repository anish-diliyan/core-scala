package play_ground

object CurriedFunction extends App {
  // Arrow is right associative: that means go from left to right
  // Int => (Int => Int)
  //val superAdder = (x: Int) => (y: Int) => x + y
  val superAdder = (x: Int) => {
    (y: Int) => {
      x + y
    }
  }
  val result = superAdder(10) // result = (y: Int) => x + y
  val finalResult = result(20) // final result = x + y
  println(finalResult)

  // functions with multiple parameter list
  // write a function to convert "double to string" according to given format
  def curriedFormater(c: String)(x: Double): String = c.format(x)

  val standardFormat: Double => String = curriedFormater("%4.2f")
  val preciseFormat: Double => String = curriedFormater("%10.8f")

  println(standardFormat(Math.PI)) // 3.14
  println(preciseFormat(Math.PI)) // 3.14159265

 }
