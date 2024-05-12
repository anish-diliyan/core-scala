package fp.hof_curries

object E3Exercise extends App {
  def superAdder(x: Int): Int => Int =  {
     (y: Int) => x + y
  }
  superAdder(10)(20)
  val niceSuperAdder = (x: Int) => (y: Int) => x + y

  def defSupperAdder(x: Int)(y: Int): Int = {
    x + y
  }

  val addThreeNumber: Int => (Int => (Int => Int)) =
    (x: Int) => (y: Int) => (z: Int) => x + y + z
}
