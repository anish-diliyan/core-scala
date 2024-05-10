package collection

object MapExample extends App {
  val myMap = Map("apple" -> 1, "banana" -> 2)
  // get values
  val iterators: Iterable[Int] = myMap.values
  println(iterators)

  val orange: Option[Int] = myMap.get("orange")

  for(entries <- myMap) {
    println(s"${entries._1}, ${entries._2}")
  }
}
