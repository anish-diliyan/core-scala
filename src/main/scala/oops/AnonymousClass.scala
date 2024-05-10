package oops

object AnonymousClass extends App{
 /*
  * 1. Create a Generic Trait MyPredicate[T], it will have a method to test T for condition
  * 2. Create a Generic Trait MyTransformer[A, B], it will have a method to convert A -> B
  * 3. Add functions into MyList
  *   ----- map(transformer): return MyList
  *   ----- filter(predicate): return MyList
  *   ----- flatMap(transformer from A to MyList[B]): return MyList[B]
  *  [1, 2, 3, 4].map(n * 2) => [1, 2, 6, 8]
  *  [1, 2, 3, 4].filter(n % 2) => [2, 4]
  *  [1, 2, 3, 4].flatMap(n => [n, n+1]) => [1, 2, 2, 3, 3, 4, 4, 5]
  */
}
