package collection

/*
 * You cannot use reduce on an empty collection. You will get an exception if you do,
 * so make sure your collection is not empty before you pass it to reduce.
 * Scala provides an alternative, reduceOption, that does not throw an exception,
 * but represents the result as an Option.
 */
/*
 * fold takes a binary operation just as reduce does, but it also takes a starting value
 * in addition to the collection. That is how fold can handle empty collections.
 * If the collection is empty, you’re just left with the starting value.
 */
object ReduceFold extends App {
  val a = Array(12, 6, 15, 2)
  // 12 + 6 = 18 + 15 = 33 + 2 = 35
  val result = a.reduceLeft((x, y) => { println(s" x = $x and y = $y"); x + y } )
  println(result)
  // 10 + 12 = 22 + 6 = 28 + 15 = 43 + 2 = 45
  val result2 = a.foldLeft(10)((x, y) => { println(s" x = $x and y = $y"); x + y } )
  println(result2)
}
