package syntaxSugar

object SyntacticSugar extends App {
  class Person(val name: String, movie: String){
    def likes(movie: String): Boolean = movie == this.movie
    def isAlive: Boolean = true
    def apply(): Boolean = true
  }
  val mary: Person = new Person("mary", "inception")
  println(mary.likes("inception"))
  /*
   * infix/operator notation
   * method with single parameter can be called as operators
   * all operators are methods
   */
  println(mary likes "inception")
  /*
   * prefix notation
   * unary_prefix method can be called in prefix notation
   * only supported prefix for unary is + - ~ !
   */
  val y = 1.unary_-
  val x = -1
  /*
   * postfix notation
   * methods without parameter can be called as postfix notation
   * this is not recommended to use because its a matter of . only
   */
   println(mary.isAlive)
   import scala.language.postfixOps
   println(mary isAlive)
   /*
    * apply method: reference variable can be called like function
    * when calling reference variable like a function it will internally
    * call apply function.
    */
   println(mary.apply())
   println(mary())

   
}
