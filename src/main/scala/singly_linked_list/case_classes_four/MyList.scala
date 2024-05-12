package singly_linked_list.case_classes_four

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](ele: B): MyList[B]
  def printElements: String
  override def toString: String = "[ " +printElements+ " ]"

  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
  
  def ++[B >: A](list: MyList[B]): MyList[B]
}
