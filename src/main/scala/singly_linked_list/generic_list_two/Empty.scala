package singly_linked_list.generic_list_two

object Empty extends MyList[Nothing] {

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](ele: B): MyList[B] = Cons(ele, Empty)

  override def head: Nothing = throw new NoSuchElementException("MyList IS EMPTY")

  override def tail: Nothing = throw new NoSuchElementException("MyList IS EMPTY")

  override  def printElements: String = ""
}
