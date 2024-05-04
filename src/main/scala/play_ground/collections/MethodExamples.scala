package play_ground.collections

// Convert in Array[String]
object StringToArray extends App {
  val s = " eggs, milk, butter, Coco Puffs "
  s.split(",").map(_.trim).foreach(println)
}

// ToUpperCase if length > 5
object ToUpperCase extends  App {
  val fruits = List("apple", "banana", "lime", "orange", "raspberry")
  val results = fruits.map {
    case fruit if fruit.length > 5 => fruit.toUpperCase
    case fruit => fruit
  }
  println(results)
}

// list of lists into a single list
object ListOfList extends App {
  val lol: List[List[Int]] = List(List(1,2), List(3,4))
  val result = lol.flatten
  println(result)
}

// sort name in alphabetic order
object SortTheName extends App {
  val couples = List(List("kim", "al"), List("julia", "terry"))
  val result = couples.flatten.map(_.capitalize).sorted
  println(result)
}

// find your all friends
object ListUniqueFriends extends App {
  val myFriends = List("Adam", "David", "Frank")
  val adamsFriends = List("Nick K", "Bill M")
  val davidsFriends = List("Becca G", "Kenny D", "Bill M")
  val friendsOfFriends = List(adamsFriends, davidsFriends)

  val myAllFiends = myFriends ++ friendsOfFriends.flatten.distinct
  println(myAllFiends)
}

// Options is also a "container like list" having either one element or zero element
object ListOfOption extends App {
  val x = Vector(Some(1), None, Some(3), None)
  val result = x.flatten
  println(result)
}

// add the numbers from bag
object SumOfTheNumbers extends App {
  val bag = List("1", "2", "three", "4", "one hundred seventy five")

  def toInt(str: String): Option[Int] = {
    try {
      Some(str.trim.toInt)
    } catch {
      case exception: Exception => None
    }
  }

  val result = bag.flatMap(toInt).sum
  println(result)
}

// filter only strings from list
object FilterOnlyStrings extends App {
  val list = "apple" :: "banana" :: 1 :: 2 :: Nil

  def onlyStrings(a: Any): Boolean = { a match
    case a: String => true
    case _ => false
  }

  val results = list.filter(onlyStrings)
  println(results)
}

object PortionEvenOdd extends App {
  val numbers: List[Int] = List(1, 2, 11, 4, 5, 6, 7, 8, 9, 10)
  val result = numbers.partition(_ % 2 == 0)
  println(result)
  val result2 = numbers.takeWhile(_ < 4)
}

object GroupByEvenOdd extends App {
  val x = List(15, 10, 5, 8, 20, 12)
  val result1 = x.groupBy(_ > 10)
  println(result1) // HashMap(false -> List(10, 5, 8), true -> List(15, 20, 12)
  val result2 = x.span(_ > 10)
  println(result2) // (List(15),List(10, 5, 8, 20, 12))
  val result3 = x.partition(_ > 10)
  println(result3) // (List(15, 20, 12),List(10, 5, 8))
  val result4 = x.splitAt(2)
  println(result4) // (List(15, 10),List(5, 8, 20, 12))
}

object UnzipCouple extends App {
  val couples = List(("Kim", "Al"), ("Julia", "Terry"))
  val (men, women) = couples.unzip
  println(men) // List(Kim, Julia)
  println(women) // List(Al, Terry)
}

object ZipMenWomen extends App {
  val women = List("kim", "Julia")
  val men = List("Al", "Terry", "extra")
  val couple = men zip women
  println(couple) // List((Al,kim), (Terry,Julia))
}

object ReduceFoldExample extends App {
  val a = Array(12, 6, 15, 2)
  // 12 + 6 = 18 + 15 = 33 + 2 = 35
  val result = a.reduceLeft((x, y) => { println(s" x = $x and y = $y"); x + y } )
  println(result)
  // 10 + 12 = 22 + 6 = 28 + 15 = 43 + 2 = 45
  val result2 = a.foldLeft(10)((x, y) => { println(s" x = $x and y = $y"); x + y } )
  println(result2)
}

object SetOperations extends App {
  val a = List(1,2,3,4,5)
  val b = List(4,5,6,7,8)

  // keep all the elements
  val mergeOrUnion = a ++ b
  println(mergeOrUnion) // List(1, 2, 3, 4, 5, 4, 5, 6, 7, 8)

  // keep common elements
  val intersect = a intersect b
  println(intersect) // List(4, 5)

  // keep a but element does not exists in b
  val diff = a diff b
  println(diff) // List(1, 2, 3)

  // :::, ::, +:, :+
  // merge b in a
  val threeDot =  a ::: b
  println(threeDot) // List(1, 2, 3, 4, 5, 4, 5, 6, 7, 8)
  // add b in a as single element
  val twoDot = a :: b
  println(twoDot) // List(List(1, 2, 3, 4, 5), 4, 5, 6, 7, 8)

  val dotPlus = a :+ b
  println(dotPlus) // List(1, 2, 3, 4, 5, List(4, 5, 6, 7, 8))

  val plusDot = a +: b
  println(plusDot) // List(List(1, 2, 3, 4, 5), 4, 5, 6, 7, 8)
}