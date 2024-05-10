package singly_linked_list.add_mthods

object Empty extends MyList[Nothing] {

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](ele: B): MyList[B] = Cons(ele, Empty)

  override def head: Nothing = throw new NoSuchElementException("MyList IS EMPTY")

  override def tail: Nothing = throw new NoSuchElementException("MyList IS EMPTY")

  override  def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}
