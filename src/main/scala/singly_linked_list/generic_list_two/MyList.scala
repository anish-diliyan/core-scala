package singly_linked_list.generic_list_two

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](ele: B): MyList[B]
  def printElements: String
  override def toString: String = "[ " +printElements+ " ]"
}
