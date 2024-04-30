package oops

object  ClassDefinition extends App {
  class Point {
    private var _x = 0
    private var _y = 0
    private val bound = 100

    def x: Int = _x

    def x_=(newValue: Int): Unit =
      if newValue < bound then
        _x = newValue
      else
        printWarning()

    def y: Int = _y

    // to make setter use variable name with _
    def y_=(newValue: Int): Unit =
      if newValue < bound then
        _y = newValue
      else
        printWarning()

    private def printWarning(): Unit =
      println("WARNING: Out of bounds")
  }

  private val point = Point()
  point.x = 99
  point.y = 98 // prints the warning

  println(s"${point.x} and ${point.y}")
}


