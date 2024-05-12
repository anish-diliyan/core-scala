package singly_linked_list.function_types_five

object ListTest extends App {
  val list = Cons(1, Empty)
  val newList = list.add(2).add(3).add(4)
  println(newList.toString)
  val evenList = newList.filter(ele => ele % 2 == 0)
  println(evenList)
  val mapList = newList.map(ele => ele * 2)
  println(mapList)
  val stringList: MyList[String] = Cons("one", Cons("two", Empty))
  val concatenateList = newList ++ stringList
  println(concatenateList)

  val flatMapList = newList.flatMap(ele => Cons[Int](ele * 10, Empty))
  println(flatMapList)
}
