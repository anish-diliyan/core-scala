package oops

object Generics extends App {
   class MyList[A] {
     // use the type A
   }

   // Provide actual type where using the class
   val listOfIntegers = new MyList[Int]
   val listOfStrings = new MyList[String]

   // can have multiple types
   class MyMap[A, B]

   // generic methods
   object MyList {
      def empty[A]: MyList[A] = new MyList[A]
   }
   val emptyListOfIntegers: MyList[Int] = MyList.empty[Int]

   // variance problem
   class Animal
   class Cat extends Animal
   class Dog extends Animal

   // Question: if Cat extends Animal does List of Cat also extends List of Animal????
   // Answer: their is three possible answer 1. Yes 2. No 3. Hell! No

}
