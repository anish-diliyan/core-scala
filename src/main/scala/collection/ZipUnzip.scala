package collection

/*
 * 
 */
object ZipUnzip extends App {
  val days = Vector("Sun", "Mon", "Tue", "Wed", "Thus", "Fri", "Sat")

  // Vector((Sun,0), (Mon,1), (Tue,2), (Wed,3), (Thus,4), (Fri,5), (Sat,6))
  val daysWithIndex: Vector[(String, Int)] = days.zipWithIndex

  // Using foreach
  daysWithIndex.foreach {
    case (days, index) => println(s"${index+1} day is $days")
  }

  // Using for loop
  for((days, index) <- daysWithIndex) {
    println(s"${index+1} day is $days")
  }

  // In both cases using "index+1" to start counting from 1. but their is another method
  // zip gives you a way to control the starting value:

  //Vector((Sun,10), (Mon,20), (Tue,30), (Wed,40), (Thus,50), (Fri,60), (Sat,70))
  val daysWithZip = days.zip(LazyList.from(10, 10))

  val unZipDays: (Vector[String], Vector[Int]) = daysWithZip.unzip
  val (day, index) = unZipDays
  println(day)
  println(index)
}
