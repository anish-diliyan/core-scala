package fp

// DREAM: use function as first class element
// first class element is instance of classes
// problem: java is oops
object Functions extends App {
  def abcd(): Unit = {
    true
  }
  trait MyFunction[A, B] {
    def apply(ele: A): B
  }
  // doubler is instance of that is implementing MyFunction and overriding apply
  val doubler = new MyFunction[Int, Int] {
    override def apply(ele: Int): Int = ele * 2
  }
  println(doubler(3))
  /*
   * scala support function type out of the box
   * By using predefined traits Function, Function1...Function22
   * all scala functions are object of function types
   */

  //Function1[String, Int] can be written as (String) => Int
  val stringToInt: Function1[String, Int] = new Function1[String, Int] {
    override def apply(value: String): Int = value.toInt
  }
  // creating instance of Function1 and overriding apply in a better way
  // And this syntax of creating instance is called LAMBDA
  // So LAMBDA is instance of function types
  val stringToIntBetter: String => Int = (x: String) => x.toInt
  val stringToIntBetter1 = (x: String) => x.toInt
  /*
   * val stringToIntBetter2 = (x) => x.toInt
   * could not infer type of parameter x: Compile time error
   */
  // type of x would be inferred from declared type String => Int
  val stringToIntBetter2: String => Int = x => x.toInt
  println(stringToInt("4"))

  // Function2[Int, Int, Int] can be written as (Int, Int) => Int
  val adder: Function2[Int, Int, Int] = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }
  // here type of x and y is defined
  val adderBetter = (x: Int, y: Int) => x + y
  // here type of x and y is inferred
  val adderBetter1: (Int, Int) => Int = (x, y) => x + y
  println(adder(10, 20))

  // NO Params Lambda
  val justDoSomething: () => Int = () => 3
  val justDoSomethingBetter = () => 3
  // careful while calling no param lambda
  println(justDoSomething) // play_ground.Functions$$$Lambda$23/0x00000008000d4440@612fc6eb
  println(justDoSomething()) // 3

  // More syntactic sugar
  val niceInc: Int => Int = _ + 1 // x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // (x, y) => x + y
}
