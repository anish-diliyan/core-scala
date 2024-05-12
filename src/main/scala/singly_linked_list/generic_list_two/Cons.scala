package singly_linked_list.generic_list_two

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](ele: B): MyList[B] = Cons(ele, this)

  override  def printElements: String = {
    if(t.isEmpty) "" + h
    else t.printElements + ", " + h
  }
}
