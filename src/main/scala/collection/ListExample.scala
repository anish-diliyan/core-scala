package collection

object ListExample extends App {
  val list: List[Int] = List(1, 2, 3, 4, 5)
  val list1: List[Int] = 2 :: 1 :: Nil
  
  // add tow lists
  val mergedList = list ++ list1
  println(mergedList)
  val mergedList1 = list1 ::: list
  println(mergedList1)
  
  // add element ito list
  val addSix =  6 :: list
  println(addSix)
  
  val addSeven = list :+ 7 
  println(addSeven)
  val addEight = 8 +: list
  println(addEight)
}
