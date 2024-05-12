package singly_linked_list.add_methods_three

object ListTest extends App {
  val list = Cons(1, Empty)
  val newList = list.add(2).add(3).add(4)
  println(newList.toString)
  val evenList = newList.filter(new MyPredicate[Int]{
    override def test(ele: Int): Boolean = ele % 2 == 0
  })
  println(evenList)
  val mapList = newList.map(new MyTransformer[Int, Int]{
    override def transform(ele: Int): Int = ele * 2
  })
  println(mapList)
  val stringList: MyList[String] = Cons("one", Cons("two", Empty))
  val concatenateList = newList ++ stringList
  println(concatenateList)

  val flatMapList = newList.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(ele: Int): MyList[Int] = Cons[Int](ele * 10, Empty)
  })
  println(flatMapList)
}
