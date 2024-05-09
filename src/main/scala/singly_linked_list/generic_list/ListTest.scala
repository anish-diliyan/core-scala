package singly_linked_list.generic_list

object ListTest extends App {
  val list = Cons(1, Empty)
  val newList = list.add(2)
  println(newList.toString)
}
