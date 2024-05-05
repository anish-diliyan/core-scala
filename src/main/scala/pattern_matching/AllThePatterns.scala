package pattern_matching

object AllThePatterns extends App {

  val x: Any = "scala"
  // 1. match constant (singleton object is also constants)
  x match {
    case 1 => "this is 1"
    case "name" => "This is string"
    case true => "This is Boolean match"
    case AllThePatterns => "Any singleton object"
  }

  // 2. Match AnyThing
  // 2.1 using wildcard _
  val matchAnyThing =x match {
    case _ => "This will match anything"
  }
  // 2.2 using variable
  val matchAVariable = x match {
    // something can match any value, and will be used in return expressing
    case something => s"I have found $something"
  }

  // 3. Tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 2) => "This is exact match"
    // will extract something from out of the tuple if rest of the pattern matches
    case (something, 2) => s"I have found $something"
  }
  val nestedTuple = (1, (2, 3))
  nestedTuple  match {
    case (_, (2, v)) => "First will match any thing and v will match with 3"
  }

  // 4. List matching
  val aStandardList = List(1, 2, 3, 42)
  val standardListMatching = aStandardList match {
    case List(1, 2, _ , _) => "even though List is not a case class but extractor exists"
    case head :: tail => println(s"head = $head and tail = $tail")
    case Nil => "Will match with empty list"
  }
  println(standardListMatching)

  // 5. match on type
  val unknown: Any = 2
  unknown match {
    case list: List[Int] => "this will match if unknown is list of Int"
    case _ => "this is default match"
  }

  // 6. name of the pattern (name binding)
  unknown match {
    case integer @ x: Int => "we can use the known here"
  }

  // 7. multi pattern
  unknown match {
    case "abd" | null => "unknown should be 'abcd' or null"
  }

  // 8. if guards
  val listWithGuards = List(1, 2, 4, 8)
  listWithGuards match {
    case List(_, _, shouldBefFour, _) if shouldBefFour == 4 => println(s"$listWithGuards")
  }
}
