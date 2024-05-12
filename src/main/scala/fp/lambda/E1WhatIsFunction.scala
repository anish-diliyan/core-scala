package fp.lambda

object E1WhatIsFunction extends App {

  trait MyFunction{
    def apply(ele: Int): String
  }
  val doubler = new MyFunction {
    override def apply(ele: Int): String = "I will double the value"
  }
  println(doubler(10)) // calling apply of MyFunction

  val niceDoubler = new Function[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }
  println(niceDoubler(10))
  val adder = new Function2[Int, Int, Int]{
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }
  println(adder(10, 20))
 }
