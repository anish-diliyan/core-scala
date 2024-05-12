package collection.map

import scala.util.Try

object E2LookUpMap extends App {
  val myMap = Map(1 -> "a", 2 -> "b", 3 -> "c", 4 -> "d")

  val keyExistApply: String = myMap(1)
  println(s"key exist apply $keyExistApply") // a
  val keyNotExistApply: Try[String] = Try {
    myMap(5)
  }
  println(s"key not exist apply ${keyNotExistApply.getOrElse("NoSuchElementException")}")


  val keyExistGet: Option[String] = myMap.get(1);
  println(s"key exist get $keyExistGet") // Some(a)
  val keyNotExistGet: Option[String] = myMap.get(5)
  println(s"key not exist get $keyNotExistGet") //None


  val keyExistGetOrElse: String = myMap.getOrElse(1, "key not found")
  println(s"key exist: get or else $keyExistGetOrElse") // a
  val keyNotExistGetOrElse: String = myMap.getOrElse(5, "key not found")
  println(s"key not exist: get or else $keyNotExistGetOrElse") // key not found

  val keyExistContains: Boolean = myMap.contains(1)
  println(s"key exist: contains $keyExistContains") // true
  val keyNotExistContains: Boolean = myMap.contains(5)
  println(s"key not exist: contains $keyNotExistContains") // false


  val keyExistIsDefinedAt: Boolean = myMap.isDefinedAt(1)
  println(s"key exist: is defined at $keyExistContains") // true
  val keyNotExistIsDefinedAt: Boolean = myMap.isDefinedAt(5)
  println(s"key not exist: is defined at $keyNotExistContains") // false

  // contains and isDefined at both are identical function, use any of them
  // The fundamental lookup method for a map is: def get(key): Option[Value]
}
