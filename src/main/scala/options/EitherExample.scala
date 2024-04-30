package options

object EitherExample extends  App {
  def divide(a: Int, b: Int): Either[String, Int] = {
    if (b == 0) Left("Division by zero")
    else Right(a / b)
  }
  val result1 = divide(10, 2)
  result1 match {
    case Left(value) => println(value)
    case Right(value) => println(value) // 5
  }
  val result2 = divide(10, 0)
  result2 match {
    case Left(value) => println(value) // Division by zero
    case Right(value) => println(value)
  }
}
