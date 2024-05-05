package containers

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object FutureExample extends App {
  def calculateMeaningOfLife: Int = {
    Thread.sleep(2000)
    42
  }

  val aFuture: Future[Int] = Future {
    calculateMeaningOfLife
  }

  println("......... waiting for the future ........")

  // onComplete returns Unit
  // onComplete will be called by some thread, it may be this thread, or it may
  // be some other thread, so we do not know which thread will execute onComplete
  // partial function
  aFuture.onComplete {
    case Success(meaningOfLife) => println(s"meaning of life is $meaningOfLife")
    case Failure(exception) => println(s"I have failed with $exception")
  }

  // map: if aFuture Fails then aMappedFuture/aFlatMappedFuture/ will also fail with same exception
  val aMappedFuture: Future[String] = aFuture.map(ele => ele.toString)

  val aFlatMappedFuture: Future[String] = aFuture.flatMap(ele => Future(ele.toString))

  // if ele % 2 == 0 is false => then aFilterFuture fails with NoSuchElementException
  val aFilterFuture = aFuture.filter(ele => ele % 9 == 0)
  aFilterFuture.onComplete {
    case Success(value) => println(s"value is $value")
    case Failure(ex) => println(s"exception is $ex")
  }
  
  // fallbacks: 
  // 1. recovery
  val aRecoverFuture: Future[Int] = aFilterFuture.recover {
    case e: Exception => 43
  }
  // 2. recoverWith
  val aRecoverWithFuture: Future[Int] = aFilterFuture.recoverWith {
    case e: Exception => Future(43)
  }
  // fallback:- if first future fails, the argument of second future will run
  // if second future also fails then the output will be result of first future.  
  val falBackResult = aFuture
  // Added this to 
  // keep main future running
  Thread.sleep(4000)

}
