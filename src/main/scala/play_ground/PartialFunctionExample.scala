package play_ground

// Unlike total function has as many parameters a Partial function can have
// "only one parameter"
object PartialFunctionExample extends App {
  // aFunction is an instance of Function1[Int, Int] ===== (Int) => (Int)
  val aFunction = (x: Int) => x + 1
  /*
   * aFunction is a function which will accept "any int value" and return with plus 1
   * But what if we need aFunction that accept "certain part of int" like "1, 2, 3, 4, 5" only
   * And for rest of the int value aFunction should not be applicable
   */
  val aFussyFunction = (x: Int) => {
    if(x >= 1 && x<=5) x + 1
    else throw new FunctionNotApplicableException
  }
  class FunctionNotApplicableException extends RuntimeException

  // {1, 2, 3, 4, 5} => Int
  // because {1, 2, 3, 4, 5} is a subset of int so this is called a partial function
  // form Int => Int, because it accepts only a part of int domain as argument
  val aNicerFussyFunction = (x: Int) => x match
    case x if x >= 1 && x <= 5 => x + 1

  // Scala supports the partial implementation using  PartialFunction, and short hand notation for writing it is
  val aPartialFunction: PartialFunction[Int, Int] = {
    case x if x >= 1 && x <= 5 => x + 1
  } // { .... } is a partial function value and equivalent to "aNicerFussyFunction"

  // Partial functions as we see here will act like proper function, in the sense
  // like it can be called and used like any other functions

  // aPartialFunction(2) here we are calling a apply method of PartialFunction[Int, Int]
  val aPartialFunctionResult = aPartialFunction(2)
  println(aPartialFunctionResult) // 3
  //val aPartialFunctionError = aPartialFunction(10)
  //println(aPartialFunctionError) // Match Error

  // Now at this point of time we know what is partial function and how it work
  // so following is some utilities of partial function

  // isDefinedAt: this is very useful to figure out the PF can run with this argument or not
  println(aPartialFunction.isDefinedAt(10)) // false

  // lift: Can be lifted to a total function returning containers, because if a PF is not
  // defined for given argument it will just return None
  val lifted: Int => Option[Int] = aPartialFunction.lift
  println(lifted(2)) // Some(3)
  println(lifted(10)) // None

  //orElse: aPartialFunction will fallback to orElse part in case of Match error
  val pfChain: PartialFunction[Int, Int] = aPartialFunction.orElse{
    case 10 => 10 + 1
  }
  println(pfChain(10)) // 11

  // PF can be used to provide implementation of total function, because PF is a subtype
  // of total function
  val aTotalFunction: Int => Int = {
    case 1 => 99
  }
  // Because of the above, our favorite HOF like map, flatMap, filter accepts PF as well
  val aMappedList = List(1, 2, 3).map{
    case 1 => 42
    case 2 => 76
    case 3 => 1000
  }
  println(aMappedList) // List(42, 76, 1000)

  val aErrorMappedList = List(1, 2, 3).map{
    case 1 => 42
    case 2 => 76
    case 5 => 1000
  }
  println(aErrorMappedList) // Caused by: scala.MatchError: 3

}
