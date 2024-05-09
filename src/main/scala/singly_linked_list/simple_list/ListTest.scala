package singly_linked_list.simple_list

import singly_linked_list.Cons
import singly_linked_list.simple_list.Empty

object ListTest extends App {
  val list = Cons(1, Empty)
  val newList = list.add(2)
  println(newList.toString)
}
