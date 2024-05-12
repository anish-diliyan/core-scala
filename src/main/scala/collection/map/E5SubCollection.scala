package collection.map

object E5SubCollection extends App {

  var myMap = Map(1 -> "a", 2 -> "b", 3 -> "c", 4 -> "d")

  val keySet: Set[Int] = myMap.keySet
  println(keySet) // Set(1, 2, 3, 4)


  val keys: Iterable[Int] = myMap.keys
  println(keys) // Set(1, 2, 3, 4)
  val keysIterator: Iterator[Int] = myMap.keysIterator
  println(keysIterator) // <iterator>


  val values: Iterable[String] = myMap.values
  println(values) // Iterable(a, b, c, d)
  val valuesIterator: Iterator[String] = myMap.valuesIterator
  println(valuesIterator) // // <iterator>

}
