package fp

object AnonymousFunction extends App{
  val stringToInt: String => Int = new Function1[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }
  // we do not need to override apply of Function1
  // Here overriding apply of Function[String, Int]
  // (x: String) --> parameter of apply
  // x.toInt => implementation of apply
  // This is called anonymous function or lambda function
  val stringToInt1 = (x: String) => x.toInt

  // Lambda with no param
  val doSomething: () => String = () => "Not available"
  val doSomething1 = () => "No available"

  // Lambda with single parameter
  val doubler: Int => Int =  x => x * 2
  val doubler1 = (x: Int) => x * 2 // this is recommended
  val doubler3: Int => Int = _ + 2
  println(doubler3)
  println(doubler3(4))

  // Lambda with multiple parameter
  val adder = (x: Int, y: Int) => x + y
  val adder1: (Int, Int) => Int = (x, y) => x + y
  val adder3: (Int, Int) => Int = _ + _

}
