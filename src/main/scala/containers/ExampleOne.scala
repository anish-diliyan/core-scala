package containers

object ExampleOne extends App {
  def getUserById(id: Int): Option[String] = {
    if (id == 1) Some("Alice")
    else None
  }
  val userId = 1
  val user = getUserById(userId)
  // pattern matching
  user match {
    case Some(name) => println(s"User found: $name")
    case None => println("User not found")
  }
  // map function will execute if Option is Non Empty, for Empty it will return None
  val mapResult = user.map(x => x.toUpperCase)
  println(mapResult) // Some(ALICE)

  // flatMap function will execute if Option is non empty, for empty it will return None
  val flatMapResult = user.flatMap(x => {
    if(x.startsWith("A")) Some("Start With A")
    else None
  })
  println(flatMapResult) // Some(Start With A)

  // filter return the Some(value) if condition matched else return None
  val filterResult = user.filter(x => x.startsWith("A"))
  println(filterResult) // Some(Alice)

  // fold return the output of first () if option is empty else output of second ()
  val foldResult = user.fold("Option is Empty")(x => x.toUpperCase())
  println(foldResult) // if option is empty => Option is Empty || for non empty ALICE

  //collect: return Some(value) if condition matched else None
  val collectResult = user.collect{
    case x if x.startsWith("A") => "Start with A"
  }
  println(collectResult) //Some("Start with A") or None

  val forYieldResult = for {
    x <- user
    y <- user if y startsWith "a"
  } yield (x.toUpperCase, y.toUpperCase)
  println(forYieldResult) // Some(ALICE)
}
