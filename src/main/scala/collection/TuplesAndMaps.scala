package collection

object TuplesAndMaps extends  App {
  // tuples: finite ordered list
  val aTuple = Tuple2(1, "a") // Type = Tuple2[Int, String] => (Int, String)

  val anotherTuple: (Int, String) = (1, "a") // shorthand to create tuple

  println(aTuple._1) // 1
  println(aTuple._2) // "a"
  println(aTuple.copy(_2 = "Anish")) // (1, Anish)
  println(aTuple.swap) // (a, 1)
  // This is generally used to define key-value pairs
  // shorthand for (1, "Anish") is 1 -> "Anish"
  val shortHandTuple: (Int, String) = 1 -> "Anish"

  // Maps
  val maps = Map()
  val phoneBook = Map((1, "a"), 2 -> "b")
  println(phoneBook)
  // get value using key
  // if key does not exists will throw exception
  println(phoneBook(1)) // a
  // check either key exists or not
  println(phoneBook.contains(3))
  // create a map with default value if key not exists
  Map(1 -> "a").withDefaultValue(-1)
  // add new key-value pair
  val newPair = 3 -> "c"
  val extendedPhoneBook = phoneBook + newPair
  println(extendedPhoneBook)

  // functions on map : map flatMap and filter
  println(phoneBook.map(x => x._1 -> x._2.toUpperCase()))
  // filter pairs with even keys
  println(phoneBook.filter(x => x._1 % 2 == 0))

  // group By
  val names = Map(1 -> "Anish", 2 -> "Manish", 3 -> "Manisha", 4 -> "Anisha")
  //HashMap(false -> Map(1 -> Anish, 2 -> Manish), true -> Map(3 -> Manisha, 4 -> Anisha))
  val groupByName =  names.groupBy(name => name._2.endsWith("a"))
  println(groupByName)
  //HashMap(A -> Map(1 -> Anish, 4 -> Anisha), M -> Map(2 -> Manish, 3 -> Manisha))
  val groupByChar = names.groupBy(name => name._2.charAt(0))
  println(groupByChar)


}
