package collection.map

object E4DeleteFromMap extends App {
  var myMap = Map(1 -> "a", 2 -> "b", 3 -> "c", 4 -> "d")

  myMap = myMap - (4) // key
  println(myMap) // Map(1 -> a, 2 -> b, 3 -> c)

  myMap = myMap -- List(1, 2, 3) // keys
  println(myMap) // Map()
}
