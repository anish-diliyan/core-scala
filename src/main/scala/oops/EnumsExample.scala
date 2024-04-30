package oops


object EnumsExample extends  App {
  // enum is a data type with all possible values is defined by case
  // this is a sealed class
  enum Permission {
    // ordinal 0, 1, 2, 3
     case READ, WRITE, EXECUTE, NONE
     // add methods
     def openDocument(): Unit = {
       if(this == READ) println("opening document ....")
       else println("reading not allowed")
     }
  }

  val somePermission: Permission = Permission.READ
  somePermission.openDocument()
  println(somePermission.ordinal) // 0
  println(Permission.values.mkString(",")) // READ, WRITE, EXECUTE, NONE
  println(Permission.valueOf("READ")) // READ

}
