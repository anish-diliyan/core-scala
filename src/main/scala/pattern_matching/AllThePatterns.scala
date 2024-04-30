package pattern_matching

object AllThePatterns extends App {

  val x: Any = "scala"
  // 1. match constant
  x match {
    case 1 => "this is 1"
    case "name" => "This is string"
    case AllThePatterns => "Any singleton object"
  }
  // 2. Match AnyThing
  // 2.1 using wildcard _
  x match {
    case _ => "This will match anything"
  }
  // 2.2 using variable
  x match {
    case aVariable => "This will match anything in this in this variable"
  }
  // 3. Tuples
  val aTuple = (1, 2)
  aTuple match {
    case (1, 2) => "This is exact match"
    case (variable, 2) => "First will match using variable"
  }
  val aNestedTuple = (1, (2, 3))
  aNestedTuple match {
    case (_, (2, v)) => "First will match any thing and v will match with 3"
  }
  // 4. List matching
  val aStandardList = List(1, 2, 3, 42)
  aStandardList match {
    case head :: tail => println("head = $head and tail = $tail")
    case List(1, 2, _ , _) => "even though List is not a case class but extractor exists"
    case List(_, _*) => "it will not restricting the number of items"
    case Nil => "Will match with empty list"
  }
  // 5. match on type
  val unknown: Any = 2
  unknown match {
    case list: List[Int] => "this will match if unkown is list of Int"
    case _ => "this is default match"
  }
  // 6. name of the pattern
  unknown match {
    case integer @ x: Int => "This is integer"
  }

  // 7. multi pattern
  unknown match {
    case "abd" | null => "x is eiter int or string"
  }
}
