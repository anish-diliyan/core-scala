package exercise

import scala.annotation.targetName

abstract class MyList[+A] {
   def head: A
   def tail: MyList[A]
   def isEmpty: Boolean
   def add[B >: A](ele: B): MyList[B]
   def printElements: String
   override def toString: String = s"[ $printElements ]"

   def map[B](transformer: A => B): MyList[B]
   def flatMap[B](transformer: A => MyList[B]): MyList[B]
   def filter(predicate: A => Boolean): MyList[A]
   @targetName("concat")
   def ++[B >: A](listL: MyList[B]): MyList[B]

   def foreach(f: A => Unit): Unit

   def sort(compare: (A, A) => Int): MyList[A]
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](ele: B): MyList[B] = Cons(ele, this)

  override def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty

  def flatMap[B](transformer: Nothing =>  MyList[B]): MyList[B] = Empty

  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  @targetName("concat")
  override def ++[B >: Nothing](listL: MyList[B]): MyList[B] = listL

  override def foreach(f: Nothing => Unit): Unit = ()

  override def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](ele: B): MyList[B] = Cons(ele, this)

  override def printElements: String = {
    if(t.isEmpty) "" + h
    else s"$h , ${t.printElements}"
  }

  override def filter(predicate: A => Boolean): MyList[A] = {
    if(predicate(h)) Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def map[B](transformer: A => B): MyList[B] = {
    Cons(transformer(h), t.map(transformer))
  }

  @targetName("concat")
  override def ++[B >: A](listL: MyList[B]): MyList[B] = {
    Cons(h, t ++ listL)
  }
  override def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  override def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  override def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if(sortedList.isEmpty)  Cons(x, Empty)
      else if(compare(x, sortedList.head) <= 0)  Cons(x, sortedList)
      else  Cons(sortedList.head, insert(x, sortedList.tail))
    }
    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }
}

object MyListTest extends App {
  val listOfIntegers: MyList[Int] = Cons[Int](1, Cons[Int](2, Cons[Int](3, Empty)))
  val  mapResult = listOfIntegers.map(new Function1[Int, Int] {
     override def apply(ele: Int): Int = ele * 2
  }).toString
  val mapResult2 = listOfIntegers.map((ele: Int) => ele * 2)
  val mapResult3 = listOfIntegers.map(_*2)
  println(mapResult)
  println(mapResult2)
  println(mapResult3)
  val filterResult = listOfIntegers.filter(new Function1[Int, Boolean] {
    override def apply(ele: Int): Boolean = ele % 2 == 0
  }).toString
  val filterResult1 = listOfIntegers.filter(ele => ele % 2 == 0)
  val filterResult2 = listOfIntegers.filter( _ % 2 == 0)
  println(filterResult)
  println(filterResult1)
  println(filterResult2)
  val flatMapResult = listOfIntegers.flatMap(new Function1[Int, MyList[Int]] {
    override def apply(ele: Int): MyList[Int] = new Cons(ele, new Cons(ele + 1, Empty))
  }).toString
  val flatMapResult1 = listOfIntegers.flatMap((ele: Int) => Cons(ele + 1, Empty))
  println(flatMapResult)

  listOfIntegers.foreach((x: Int) => println(x))

  val sortedList = listOfIntegers.sort((x, y) => y -x).toString
  println(sortedList)
}