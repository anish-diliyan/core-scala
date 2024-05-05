package fp

object LazyVal extends  App {
  lazy val x = {
    println("computing x")
    3
  }
  val y = {
    println("computing y")
    10
  }
  val resultY = y + y // x was still not computed, "computing x" was not yet printed
  println(s"value of y is $resultY")
  val resultX = x + x // x is required, x is going to be computed, a "computing x" message will be printed *once*
  println(resultX)
}
