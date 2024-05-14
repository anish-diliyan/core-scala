package collection.sorting

object SortedExample extends App {
   val listOfInt: List[Int] = List(2, 1, 4, 3, 6, 5)

   val sortedListOfIntInAsc = listOfInt.sorted

   println(sortedListOfIntInAsc) // List(1, 2, 3, 4, 5, 6)

   val listOfString: List[String] = List("B", "A", "D", "C", "F", "G")

   val sortedListOfStringInAsc = listOfString.sorted

   println(sortedListOfStringInAsc) // List(A, B, C, D, F, G)

   class Person(val name: String)
   val personList = List(new Person("A"), new Person("C"), new Person("B"))

   /*
    * val personSortedByNameAsc: List[Person] = personList.sorted
    * Compile Error: No implicit Ordering defined for Person
    * What does it mean:
    * sorted function needs implicits instance of Ordering.
    * Ok, So what is ordering: it is same as Comparator in java with compare() method
    * So fix the error by providing implicit ordering for sorted method
    */
   implicit val personToOrdering: Ordering[Person] = new Ordering[Person] {
      override def compare(x: Person, y: Person): Int = x.name.compareTo(y.name)
   }

   val personSortedByNameAsc: List[Person] = personList.sorted
   personSortedByNameAsc.foreach(person => println(person.name))

   /*
    * Here question should come in mind, why sorted was working for String and Int ????
    * Because String and Child of AnyVal implements Comparable, and override compareTo() method
    * Wait, Here I am taking about Comparable and compareTo() method, what is this?
    * The classes implements Comparable provide capabilities of Sorting to the class
    * by defining compareTo() method.
    * by default compareTo is defined for Natural sorting order: Sort in asc order
    * x.name.compareTo(y.name): Here I am able to use compareTo(), because as discussed String is
    * Comparable and compareTo() method is defined for Natural sorting order.
    * CAN I MAKE THE PERSON CLASS COMPARABLE LIKE STRING ???
    */

   // Define Natural Sorting in a way: first sort by name, if name is equal sort by age
   class ComparablePerson(val name: String, val age: Int) extends Ordered[ComparablePerson] {
      override def compare(that: ComparablePerson): Int = {
         if(this.name.equals(that.name)) this.age.compareTo(that.age)
         else this.name.compareTo(that.name)
      }
   }

   val comparablePersonList: List[ComparablePerson] = List(
      new ComparablePerson(name = "Anish", age = 30),
      new ComparablePerson(name = "Manish", age = 20),
      new ComparablePerson(name = "Anish", age = 2)
   )

   val sortedComparablePerson = comparablePersonList.sorted
   sortedComparablePerson.foreach(person => println(s"${person.name}, ${person.age}"))

   /*
    * In Last important point:
    * String and Child of AnyVal is Comparable but sorted needs implicit instance of Ordering.
    * So how does sorted work for String and Int ????????
    * It works because there is an implicit conversion method available in scope. This method can
    * return Ordering for any type which extends java.lang.Comparable.
    * Ordered also extends Comparable, that means Ordered can also be converted into Ordering implicitly.
    */
}
