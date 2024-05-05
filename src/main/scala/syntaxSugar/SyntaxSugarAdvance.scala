package syntaxSugar

import scala.util.Try

object SyntaxSugarAdvance extends App {
  // Syntax Sugar 1# method with single parameter
  def singleArgMethod(arg: Int): String = s"$arg little duck ..."

  // method with single parameter can be called with {}
  val description: String = singleArgMethod {
    // write some complex code to calculate a parameter
    42
  }
  println(description) //42 little duck ...

  // calling a Try.apply() method using {}
  val tryInstance = Try {
    throw new RuntimeException()
  }
  // calling a map function using {}
  List(1, 2, 3).map { x =>
    x + 1
  }

  // Syntax Sugar 2# single abstract method pattern
  trait Action {
    def act(x: Int): Int
  }
  // 1. either extends this trait to non abstract class
  class MyAction extends Action {
    override def act(x: Int): Int = x + 1
  }
  val myAction = new MyAction()
  // 2. or implement a anonymous class
  val aInstance = new Action {
    override def act(x: Int): Int = x + 1
  }
  // 3. Instances of trait with a single method can be reduced to lambda
  // here return type in mandatory
  val aFunkyInstance: Action = (x: Int) => x + 1

  // example
  val aThread = new Thread(() => println("hello thread"))

  // This pattern also works for "abstract classes" have some method implemented
  // but only have one method unimplemented
  abstract class AnAbstract {
    def implemented: String = "implemented"
    def unImplemented(): Unit
  }
  val anAbstractInstance: AnAbstract = () => println("I am implemented now!")

  // Syntax Sugar 3# the :: and #:: methods are special
  val prependedList = 2 :: List(3, 4)
  // 2.::(List(3,4)) normal understanding comes form infix/operator notation of method call
  // But wait...... their is no :: method on int
  // compiler will rewrite: List(3,4).::(2) but How?????????????
  // Ans: Scala compiler says last character will decide associativity of method
  // : is right associative and other is left associative
  val myList = 1 :: 2 :: 3 :: Nil // Nil is a Empty List
  val compilerList = Nil.::(3).::(2).::(1)

  // example
  class MyStream[T] {
    def -->:(value: T): MyStream[T] = {
      // here actual implementation, but i am returning this
      this
    }
  }
  val myStream = 1 -->: 2 -->: new MyStream[Int]
  // #:: -> is a prepend operator on Stream, i think this is also explained

  // Syntax Sugar 4# multi word method naming (rarely used in practice)
  class TeenGirl(name: String) {
    def `and then said`(gossip: String): Unit = println(s"$name siad $gossip")
  }
  new TeenGirl("Lily") `and then said` "Scala is so sweet!!"

  // Syntax Sugar 5# infix generic types
  class Composite[A, B]
  val composite: Composite[Int, String] = ???
  val infixTypeComposite: Int Composite String = ???

  // example
  class -->[Int, String]
  val towards: Int --> String = ???

  // Syntax Sugar 6#  update() this is also very special, much like apply()
  val anArray = Array(1, 2, 3)
  // update takes two parameter and returns Unit
  anArray(2) = 7 // rewritten by compiler: anArray.update(2, 7)
  // Now remember apply() and update()

  // Syntax Sugar 7# setters for mutable containers
  // explain by example: lets say we are ROCKSTAR scala programmer and we want to
  // create mutable wrapper over an Int.
  class Mutable {
    private var internalMember: Int = 0
    // write getter and setters
    def member: Int = internalMember
    def member_=(value: Int): Unit = internalMember = value
  }
  val aMutableContainer = new Mutable
  aMutableContainer.member = 42 // rewritten As aMutableContainer.member_=(42)
  println(aMutableContainer.member)
}
