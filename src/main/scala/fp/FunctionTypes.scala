package fp

object FunctionTypes extends App {
   val stringToInt: Function1[String, Int] = new Function[String, Int] {
     override def apply(v1: String): Int = v1.toInt
   }
   println(stringToInt("2"))

   val adder: Function2[Int, Int, Int] = new Function2[Int, Int, Int] {
     override def apply(v1: Int, v2: Int): Int = v1 + v2
   }
   println(adder(2, 2))
   // Funtion2[Int, Int, Int] can be written as (Int, Int) => Int
   val substractor: (Int, Int) => Int = new Function2[Int, Int, Int] {
     override def apply(v1: Int, v2: Int): Int = v1 - v2
   }
   println(substractor(10, 5))

   val supperAdder: Int => (Int => Int) = new Function[Int, Int => Int] {
     override def apply(v1: Int): Int => Int = new Function[Int, Int]{
       override def apply(v2: Int): Int = v1 + v2
     }
   }
   println(supperAdder(2)(2))
}
