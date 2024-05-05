package fp

object ForYield extends App {

  sealed abstract class Perhaps[A] {
    def foreach(f: A => Unit): Unit
    def map[B](f: A => B): Perhaps[B]
    def flatMap[B](f: A => Perhaps[B]): Perhaps[B]
    def withFilter(f: A => Boolean): Perhaps[A]
  }
  case class YesItIs[A](value: A) extends Perhaps[A] {
    override def foreach(f: A => Unit): Unit = f(value)
    override def map[B](f: A => B): Perhaps[B] = YesItIs(f(value))
    override def flatMap[B](f: A => Perhaps[B]): Perhaps[B] = f(value)
    override def withFilter(f: A => Boolean): Perhaps[A] = if (f(value)) this else ???
  }
  case object Nope extends Perhaps[Nothing] {
    override def foreach(f: Nothing => Unit): Unit = ()
    override def map[B](f: Nothing => B): Perhaps[B] = ???
    override def flatMap[B](f: Nothing => Perhaps[B]): Perhaps[B] = ???
    override def withFilter(f: Nothing => Boolean): Perhaps[Nothing] = ???
  }

  val y3 = YesItIs(3)
  val y4 = YesItIs(4)
  val n = Nope

  // compilation error: value foreach is not a member of YesItIs[Int]
  for {
    a <- y3
  } { println(a) }
  // same can be written As following
  y3.foreach(a => println(a))
  /*
     for {
       a <- y3
       b <- y4
     } { println(a + b) }
     * equivalent java code
     for (int a : y3) {
       for (int b : y4) {
         System.out.println(a + b);
       }
     }
  */

  // value map is not a member of YesItIs[Int], now define map in class YesItIs
  for {
    a <- y3
  } yield a * a
  // equivalent to
  y3.map(a => a * a)

  // value flatMap is not a member of YesItIs[Int], now define flatMap in class YesItIs
  for {
    a <- y3
    b <- y4
  } yield a * b
  // equivalent to
  y3.flatMap(a => y4.map(b => a * b))

  //value withFilter is not a member of YesItIs[Int], now define withFilter in YesItIs
  for {
    a <- y3 if a > 1
    b <- y4
  } yield a * b
  // equivalent to
  y3.withFilter(a => a > 1).flatMap(a => y4.map(b => a * b))
}
