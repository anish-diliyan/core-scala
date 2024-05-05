package pattern_matching

object JustTest extends App {
  val listWithGuards = List(1, 2, 4, 8)
  listWithGuards match {
    case List(_, _, shouldBefFour, _) if shouldBefFour == 4 => println(s"$listWithGuards")
  }
}
