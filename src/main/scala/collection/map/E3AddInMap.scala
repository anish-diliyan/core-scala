package collection.map

object E3AddInMap extends App {
   var myMap = Map(1 -> "a", 2 -> "b", 3 -> "c")

   // add an single element
   myMap = myMap + (4 -> "d")
   println(myMap) // Map(1 -> a, 2 -> b, 3 -> c, 4 -> d)

   // merge another map
   myMap = myMap ++ Map(5 -> "e", 6 -> "f")
   println(myMap) // HashMap(5 -> e, 1 -> a, 6 -> f, 2 -> b, 3 -> c, 4 -> d)

   myMap = myMap.updated(1, "apple")
   println(myMap) // HashMap(5 -> e, 1 -> apple, 6 -> f, 2 -> b, 3 -> c, 4 -> d)
   
   // TODO difference between Map and HashMap ?
}
