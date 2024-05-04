package collection

/*
 * remember working of group by like this:
 * groupBy(value => key)
 * the function implementation will calculate the key.
 * Example:::::
 * ("anish", "manish", "anshu").groupBy(x => x.contains("anish"))
 * anish => anish.conatins("anish") [ anish (v) => true (k)]
 * manish => manish.contains("anish") [manish (v) => true (k)]
 * anshu => anshu.contains("anish") [anshu (v) => false (k)]
 * [true -> List(anish, manish), false -> List(anshu)]
 */
object GroupBy extends App {
  var input = List("anish", "manish", "anshu")
  // group names that contains anish
  val group1 = input.groupBy(x => x.contains("anish"))
  println(group1)
  val group2 = input.groupBy(x => x)
  println(group2)
  val group3 = input.groupBy(x => x.length == 5)
  println(group3)
}
