package singly_linked_list.simple_list_one

import singly_linked_list.Cons
import singly_linked_list.simple_list_one.Empty

object ListTest extends App {
  val list = Cons(1, Empty)
  val newList = list.add(2)
  println(newList.toString)
}
