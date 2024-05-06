package pattern_matching

object InfixPattern extends App {
   case class Or[A, B](a: A, b: B)

   val either = Or(2, "two")

   val humanDescription = either match {
      case Or(num, asString) => s"$num can be written as $asString"
   }
   println(humanDescription)

   // infix pattern only work when you will have only two things in pattern !!!!
   val infixPattern = either match {
      case num Or asString => s"$num can be written as $asString ! using infix pattern"
   }
   println(infixPattern)
}
