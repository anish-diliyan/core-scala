package singly_linked_list

object Empty extends MyList {

  override def isEmpty: Boolean = true

  override def add(ele: Int): MyList = Cons(ele, Empty)

  override def head: Int = throw new NoSuchElementException("MyList IS EMPTY")

  override def tail: MyList = throw new NoSuchElementException("MyList IS EMPTY")

  override  def printElements: String = ""
}
