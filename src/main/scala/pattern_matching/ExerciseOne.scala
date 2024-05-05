package pattern_matching

object ExerciseOne extends App {
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr
  /*
   * Write a simple function that uses pattern matching
   * and takes an Expr as parameter and rerun a human readable form of it
   * Sum(Number(2), Number(3)) => 2 + 3
   * Sum(Number(2), Number(3), Number(4)) => 2 + 3 + 4
   * Prod(Sum(Number(2), Number(1), Number(3)) => (2 + 1) * 3
   * Sum(Prod(Number(2), Number(1)), Number(3)) => 2 * 1 + 3
   */

  def show(expr: Expr): String = expr match {
    case Number(n) => s"$n"
    case Prod(e1, e2) =>
      def mayBeShowParenthesis(expr: Expr) = expr match {
        case Number(_) => show(expr)
        case Prod(_, _) => show(expr)
        case Sum(_, _) => "(" + show(expr) + ")"
      }
      mayBeShowParenthesis(e1) + " * " + mayBeShowParenthesis(e2)
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
  }
  val expr1 = Sum(Number(2), Number(3))
  println(show(expr1)) // 2 + 3
  val expr2 = Prod(Sum(Number(2), Number(1)), Number(3))
  println(show(expr2))
  val expr3 = Sum(Prod(Number(2), Number(1)), Number(3))
  println(show(expr3))
}
