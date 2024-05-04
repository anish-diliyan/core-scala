package collection

/*
 * map: transforms each value into another value.
 * flatMap: transforms each value into group of Value and then flatten.
 */
object MapFlatMap extends App {
   // map(f: A => B)
   // function f will be applied on each element of list
   val list: List[String] = List("1", "2", "3", "4", "5");
   // multiply each element by ten and convert in Int
   val listOfInt: List[Int] = list.map(_.toInt * 10)
   println(listOfInt) // List(10, 20, 30, 40, 50)

   // def flatMap[B](f: A => IterableOnce[B]): List[B]
   // function f will create a new collection for every element.
   // flatMap = map + flatten
   def getCharecters(str: String): List[Char] = {
      str.toList
   }
   // find unique characters in given sentences
   val sentences = " i am anish kumar pandey !"
   val words: List[String]  = sentences.split(" ").toList
   val uniqueChar = words.flatMap(getCharecters).distinct
   println(uniqueChar)
}
