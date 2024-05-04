package collection.sorting


object sorted extends App {
  val list = List(
    "Our", "fathers", "trusted", "in", "You", "They",
    "trusted", "and", "You", "delivered", "them"
  )
  // sort the list using default sorting order.
  println(list.sorted)

  // sort a list by length of words
  println(list.sortBy(x => x.length))

  // sort a list using lowercase of words
  println(list.sortBy(x => x.toLowerCase))

  // sort by can also work with classes
  case class Track(length: Double, name: String)

  val ts = List(
    Track(7.35, "Watcher of the Skies"),
    Track(4.783, "Time Table"),
    Track(8.583, "Get 'Em Out by Friday"),
    Track(5.75, "Can-Utility and the Coastliners"),
    Track(1.65, "Horizons"),
    Track(22.95, "Supper's Ready")
  )
  // sort by track length
  println(ts.sortBy(x => x.length))

  /*
   * But What if you need to sort Track by "Descending Order Using Length" ?????
   */
   println(ts.sortWith((obj1, obj2) => obj1.length > obj2.length))

  case class Name(first: String, last: String)

  val names = List(
    Name("Phil", "Collins"), Name("Jackie", "Collins"),
    Name("Joan", "Collins"), Name("Tom", "Collins"),
    Name("George", "Bush"), Name("Jeb", "Bush"), Name("Neil", "Bush"), Name("Marvin", "Bush")
  )

  // sort according to lastName and then first name by length desc
  println(names.sortWith((name1, name2) =>
    if(name1.last == name2.last) name1.first.length > name2.first.length
    else name1.last < name2.last
  ))

  // other function uses with sortWith is >, <, >= , <=
  /*
   * function inside sort with takes two params and return boolean(true/false)
   * (obj1, obj2) => boolean
   * return true => if you want obj1 before obj2
   * return false => if you want other
   */

}
