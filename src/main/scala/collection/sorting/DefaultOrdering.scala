package collection.sorting

/*
 *  sorted: Sorts this sequence according to an default order.
 *  Error:- No implicit Ordering defined for B, How to solve?
 *  extend an Ordered trait and override compare method.
 *  But according to error it was looking for implicit Ordering.
 *  So Ordered companion object provide implicit orderingToOrdered.
 */
// Default ordering of Employee
case class Employee(id: Int, sal: Long) extends Ordered[Employee] {
  override def compare(that: Employee): Int = {
    this.sal compare that.sal
  }
}
object DefaultOrdering extends App {
  val e1 = Employee(1, 1000)
  val e2 = Employee(3, 3000)
  val e3 = Employee(2, 2000)
  val emp = List(e1, e2, e3)
  println(emp.sorted)
}
