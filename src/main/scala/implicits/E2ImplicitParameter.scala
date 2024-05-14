package implicits

object E2ImplicitParameter extends App {
  implicit val defaultInc: Int = 10
  def increment(ele: Int)(implicit incBy: Int): Int = ele + incBy

  println(increment(10)(20)) // 30

  // let the compiler find the implicit parameter and replace this
  println(increment(10))  // 20

}
