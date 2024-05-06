package pattern_matching

object ExerciseTwo extends App{
  /*
   *  Create your own pattern matching for an annoying case
   *  Where you want to match against integers.
   *  But instead of matching against actual values, your gonna match
   *  Against multiple conditions
   */
   object even {
     def unapply(num: Int): Boolean = num % 2 == 0
   }

   object singleDigit {
     def unapply(num: Int): Boolean = num < 10 && num > -10
   }

   val n: Int = 45
   val result = n match {
     case even() => "Number is even"
     case singleDigit() => "Number is single digit"
     case _ => "No property matched"
   }
   println(result)
}
