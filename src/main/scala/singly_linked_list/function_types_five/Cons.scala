package singly_linked_list.function_types_five

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](ele: B): MyList[B] = Cons(ele, this)

  override  def printElements: String = {
    if(t.isEmpty) "" + h
    else t.printElements + ", " + h
  }

  def map[B](transform: A => B): MyList[B] = {
    Cons(transform(h), t.map(transform))
  }
  def flatMap[B](transform: A => MyList[B]): MyList[B] = {
    transform(h) ++ t.flatMap(transform)
  }
  def filter(test: A => Boolean): MyList[A] = {
    if(test(h)) Cons[A](h, t.filter(test))
    else t.filter(test)
  }
  def ++[B >: A](list: MyList[B]): MyList[B] = Cons(h, t ++ list)
}
