package collection

/*
 * collect: filter then map
 * filter out unwanted values, but transform the ones that are left.
 * collect takes a PartialFunction
 * If the partial function is not defined for the input element, then discards it.
 */
def filterAndMap(list: List[Int]): List[Int] = {
  list.filter(_ % 2 == 0).map(x => x * x)
}
object FilterCollect extends App {
  // find square root of even numbers in list
  val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val result = filterAndMap(list)
  println(result) // List(4, 16, 36, 64, 100)
  val result2 = list.collect {
    case x if x % 2 == 0 => x * x
  }
  println(result2)
}

object CancelledOrder extends App {
  trait Order
  case class Fulfilled(id: Int, total: BigDecimal)
  case class Cancelled(id: Int, total: BigDecimal)

  val orders = List(
    Fulfilled(1, BigDecimal("28.50")),
    Fulfilled(2, BigDecimal("88.25")),
    Cancelled(3, BigDecimal("22.01")),
    Fulfilled(4, BigDecimal("39.30")),
    Fulfilled(5, BigDecimal("27.97")),
    Cancelled(6, BigDecimal("99.49")),
    Fulfilled(7, BigDecimal("53.72")),
    Cancelled(8, BigDecimal("93.66")),
    Cancelled(9, BigDecimal("7.79")),
    Fulfilled(10, BigDecimal("87.21"))
  )
  val result = orders.collect{
    case Cancelled(id, _) => id
  }
  println(result) // List(3, 6, 8, 9)
}