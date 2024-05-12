package collection.map

object E1CreateMap extends App {
   // creating an empty Map
   val emptyMap = Map.empty
   // creating map using tuples
   val tupleMap: Map[Int, String] = Map((1, "a"), (2, "b"), (3, "c"))
   // we can write (1, "a") as 1 -> "a"
   val nicerMap: Map[Int, String] = Map(1 -> "a", 2 -> "b", 3 -> "c")
}
