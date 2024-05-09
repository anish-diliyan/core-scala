package singly_linked_list

import singly_linked_list.simple_list.MyList

object Cons {
  def apply(h: Int, t: MyList): MyList = new Cons(h, t)
}

class Cons(h: Int, t: MyList) extends MyList {

  override def head: Int = h

  override def tail: MyList = t

  override def isEmpty: Boolean = false

  override def add(ele: Int): MyList = Cons(ele, this)

  override  def printElements: String = {
    if(t.isEmpty) "" + h
    else t.printElements + ", " + h
  }
}
