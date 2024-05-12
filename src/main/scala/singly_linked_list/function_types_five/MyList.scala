package singly_linked_list.function_types_five

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](ele: B): MyList[B]
  def printElements: String
  override def toString: String = "[ " +printElements+ " ]"

  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]
  
  def ++[B >: A](list: MyList[B]): MyList[B]
}
