package type_system

// Super will go from Right to Left in Linear Type
object SuperInheritance extends App {

  trait Cold {
    def print(): Unit = println("Cold")
  }
  trait Green extends Cold {
    override def print(): Unit = {
      println("Green")
      super.print()
    }
  }

  trait Blue extends Cold {
    override def print(): Unit = {
      println("Blue")
      super.print()
    }
  }

  class Red {
    def print(): Unit = println("Red")
  }

  class White extends Red with Green with Blue {
    override def print(): Unit = {
      println("White")
      super.print()
    }
  }
  //white -> Blue -> Green -> Cold
  new White().print()

}
