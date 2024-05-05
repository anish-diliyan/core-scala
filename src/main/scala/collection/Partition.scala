package collection

object Partition extends App {
  case class Animal(category: String)

  val animals = List(
    Animal(category = "GOAT"), Animal(category = "SHEEP"), Animal(category = "SHEEP")
  )
  // divide sheep and goat
  val result = animals.partition(x => x.category.equals("GOAT"))
  println(result)
}
