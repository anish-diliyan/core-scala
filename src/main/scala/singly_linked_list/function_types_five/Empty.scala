package singly_linked_list.function_types_five

case object Empty extends MyList[Nothing] {

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](ele: B): MyList[B] = Cons(ele, Empty)

  override def head: Nothing = throw new NoSuchElementException("MyList IS EMPTY")

  override def tail: Nothing = throw new NoSuchElementException("MyList IS EMPTY")

  override  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty

  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}
