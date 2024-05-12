package fp.udemy

object E2AnonymousFunction extends App {

  def doubler =  new Function[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }
  // Anonymous function (LAMBDA)
  def niceDoubler = (v1: Int) => v1 * 2

  // Rule 1: Parameter type is Optional, if it can be inferred

  def anotherNiceDoubler: Int => Int = v1 => v1 * 2

  val justDoVal = () => "I am no param val"
  println(justDoVal) // fp.udemy.E2AnonymousFunction$$$Lambda$16/0x00007752bc0269c8@45c8e616
  println(justDoVal()) // I am no param lambda

  def justDoDef = () => "I am no param def"
  println(justDoDef) // fp.udemy.E2AnonymousFunction$$$Lambda$19/0x0000754cd4097530@66d33a
  println(justDoDef()) // I am no param def

  val inc = (x : Int) => x + 1
  val niceInc: Int => Int = _ + 1

  val adder = (x: Int, y: Int) => x + y
  val niceAdder: (Int, Int) => Int = _ + _

  def superAdder = new Function1[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }
  def niceSuperAdder = (v1: Int) => (v2: Int) => v1 + v2

}
