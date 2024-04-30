package play_ground.collections

object MethodsForAll extends App {
  val seq = Seq(1, 2, 3, 4, 5, 6)
  val result = seq.collect(x => x*2)
  println(result)

}
