package oops

object Exceptions extends App {
  val x: String = null
  //println(x.length) // Null Pointer exception
  // Exceptions returns Nothing
  class MyException extends Exception
  try {
    throw new MyException
  } catch {
    case ex: NullPointerException => println("Exception caught")
  } finally {
    // optional
    // final does not influence return type of try-catch
    println("Execute always")
  }
}
