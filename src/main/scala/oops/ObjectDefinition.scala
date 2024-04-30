package oops

object ObjectDefinition extends App {
   class Person:
      var name = ""
      var age = 0

      override def toString = s"$name is $age years old"

   object Person:

      // a one-arg factory method
      def apply(name: String): Person =
         var p = new Person
         p.name = name
         p

      // a two-arg factory method
      def apply(name: String, age: Int): Person =
         var p = new Person
         p.name = name
         p.age = age
         p

   end Person

   val joe = Person("Joe")
   val fred = Person("Fred", 29)
}
