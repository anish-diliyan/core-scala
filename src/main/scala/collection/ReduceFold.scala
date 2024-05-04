package collection

object ReduceFold extends App {
  val a = Array(12, 6, 15, 2)
  // 12 + 6 = 18 + 15 = 33 + 2 = 35
  val result = a.reduceLeft((x, y) => { println(s" x = $x and y = $y"); x + y } )
  println(result)
  // 10 + 12 = 22 + 6 = 28 + 15 = 43 + 2 = 45
  val result2 = a.foldLeft(10)((x, y) => { println(s" x = $x and y = $y"); x + y } )
  println(result2)
}
