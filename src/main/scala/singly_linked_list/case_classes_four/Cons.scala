package singly_linked_list.case_classes_four

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](ele: B): MyList[B] = Cons(ele, this)

  override  def printElements: String = {
    if(t.isEmpty) "" + h
    else t.printElements + ", " + h
  }

  def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    Cons(transformer.transform(h), t.map(transformer))
  }
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }
  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if(predicate.test(h)) Cons[A](h, t.filter(predicate))
    else t.filter(predicate)
  }
  def ++[B >: A](list: MyList[B]): MyList[B] = Cons(h, t ++ list)
}
