package oops

object OverrideExampleOne extends App {
  class Person(name: String) {
    val canDrink: Boolean = false
    val idCard = false
    def print(): Unit = println(s"HI, I am $name and I am Person with IdCard = $idCard")
  }

  class Adult(name: String, age: Int, override val canDrink: Boolean) extends Person(name) {
    override val idCard: Boolean = true
    override def print(): Unit = {
      println(s"HI, I am $name and I am Adult of $age year old with IdCard = $idCard ! so I can drink = $canDrink")
    }
  }
  val adult = new Adult("bob", 25, true)
  adult.print()
}
