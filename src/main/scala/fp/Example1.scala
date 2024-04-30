package fp

trait Action {
  def execute(element: Int): Int
}

class MyAction extends Action {
  override def execute(element: Int): Int = element * 2
}
object Example1 extends App {
   val obj = new MyAction().execute(2)
   println(obj)
   // This is anonymous class extending Action and creating object of that class
   val anonymousClass: Action = new Action {
     override def execute(element: Int): Int = element * 2
   }
}
