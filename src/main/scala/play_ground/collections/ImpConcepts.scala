package play_ground.collections

object ImpConcepts extends App {
  // predicate:- Simply a method that returns Boolean
  def isEven(i: Int): Boolean = if(i % 2  == 0) true else false

  // anonymous function (LAMBDA)
  val isEven = (i: Int) => if(i % 2 == 0) true else false
  val list = List.range(1, 10)
  val evenNumber = list.filter(_ % 2 == 0) // x => x % 2 == 0

  // implied loops
  for {
    e <- list
    if e % 2 == 0
  } yield e

  /*
   * Difference between Traversable and Iterable ?
   * Traversable(forEach):-- will push data one by by one from collection.
   * Iterable(iterator):- you will have to pull data from collection one by one.
   */

  /*
   * Collection Hierarchy:
   * Seq, Set, Map
   * Seq(default List):- IndexedSeq(default Vector), LinearSeq(default List)
   * Vector:- array data structure, random access is efficient
   * List:- singly Linked List, can split into head and tail
   * * * * * *
   * Map:- key value pair
   * * * * * *
   * Set:- unique elements
   */
   val v = IndexedSeq(1, 2, 3 ,4); // Vector
   println(v)
   val l = Seq(1, 2, 3, 4)// List
   println(l)
   val m = Map(1 -> "a", 2 -> "b") // Map
   println(m)
   val s = Set(1, 2, 3, 4) // Set
   println(s)
   // other important collection is: Array, Range, Stream
   /*
In a strict collection, memory for the elements is allocated immediately, and all of its
elements are immediately evaluated when a transformer method is invoked.
In a lazy collection, memory for the elements is not allocated immediately, and transformer
methods do not construct new elements until they are demanded.
All of the collection classes except Stream are strict, but the other collection classes can
be converted to a lazy collection by creating a view on the collection.
    */
}
