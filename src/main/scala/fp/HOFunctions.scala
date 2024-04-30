package fp

object HOFunctions extends App {
  val list = List(1, 2, 3)
  // List(1, 2, 3)
  println(list)
  // List(1 is a number, 2 is a number, 3 is a number)
  // map will apply function on every element of list and return another list
  println(list.map(x => s"$x is a number"))
  // List(2)
  // create another list with elements for that function return true
  println(list.filter(x => x % 2 == 0))
  // List(1, 2, 2, 3, 3, 4)
  // take every element of list and apply function on that and create a single list
  // 1 => List(1, 2), 2 => List(2, 3), 3 => List(3,4)
  // List(List(1,2), List(2,3), List(3,4)) => List(1,2,2,3,3,4)
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(x => toPair(x)))
  // print all combination between two list
  // list1 = (1, 2, 3)  | list2 = (a, b, c, d)
  // result = ("1a", "1b", "1c"......."3d")
  val numbers = List(1, 2, 3)
  val strings = List("a", "b", "c", "d")
  val combinations = numbers.flatMap(x => strings.map(y => s"$x$y"))
  // apply function returning unit on each element of list
  combinations.foreach(x => println(x))

  //Each line in the expression using the <- symbol is translated to a flatMap call,
  // except for the last line which is translated to a concluding map call.
  val forCombinations = for {
    x <- numbers if  x % 2 == 0// numbers.flatMap(x => strings.map(y => s"$x$y"))
    y <- strings
  } yield {
    println(s"x = $x and y = $y")
    s"$x$y"
  }
  println(forCombinations)
}
