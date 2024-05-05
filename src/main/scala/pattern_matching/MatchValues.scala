package pattern_matching

import scala.util.Random

object MatchValues extends App {
  val random = new Random()
  val x = random.nextInt(10)

  // match values against multiple patterns
  // cases are matched in order
  // if no case matched, you will get MatchError,
  // so always use default match, to handle if nothing matched
  // type of result here description will be Unified type of return value
  val description = x match {
    case 1 => "the one"
    case 2 => "double or nothing"
    case 3 => "third time is a charm"
    case _ => "something else" // _ is wild card, will be used when nothing matched
  }
  println(s"running match for: $x")
  println(s"match result is: $description")
}
