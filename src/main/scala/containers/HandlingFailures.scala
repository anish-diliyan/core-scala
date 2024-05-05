package containers

import scala.util.{Failure, Success, Try}

object HandlingFailures extends App {
  // Multiple/Nested try makes code hard to follow
  try {
    throw new NullPointerException()
  } catch {
    case npe: NullPointerException => println("Referencing Null")
    case _: Exception => println("Unknown exception")
  }

  val result: Try[Int] = Try {
    val numerator = 10
    val denominator = 0
    numerator / denominator
  }
  println(result.isSuccess)
  println(result.isFailure)
  val orElseResult = result.getOrElse("It is failing")
  result match {
    case Success(value) => println(s"Result: $value")
    case Failure(exception) => exception match {
      case npe: NullPointerException => println("Referencing Null")
      case _: Exception => println("Unknown exception")
    }
  }
  // map: return output of function if success else return the result(exception).
  val mapResult = result.map(x => x * 2)
  println(mapResult.getOrElse("Failed"))

  // flatMap: if success return Success(10) if fails return Failure(exception)
  val flatMapResult = result.flatMap(x => Success(10))
  println(flatMapResult)

  // fold:
  // execute ex => "failed with $ex" "failed with java.lang.ArithmeticException: / by zero"
  // execute succ => s"success with $succ" "success with 5"
  val foldResult = result.fold(ex => s"failed with $ex", succ => s"success with $succ")
  println(foldResult)

}
