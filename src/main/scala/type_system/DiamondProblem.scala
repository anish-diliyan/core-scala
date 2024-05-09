package type_system

// LAST OVERRIDE GETS PICKED
object DiamondProblem extends App {
  trait Animal {
    val name: String
  }
  trait Lion extends Animal {
    override val name: String = "LION"
  }
  trait Tiger extends Animal {
    override val name: String = "TIGER"
  }
  class Mutant extends Lion with Tiger

  val mutant = new Mutant
  /*
   * Mutant has two name: Tiger.name and Lion.name. This should be conflict????
   * No, this is not a conflict scala compiler will handle this in following way:
   * Mutant extends Animal { override val name: String = "LION" }
   * with Animal{ override val name: String = "TIGER" }
   * Compiler will read the code from right to left and found
   * 1. Animal{ override val name: String = "TIGER" }
   * 2. Animal { override val name: String = "LION" }
   * So in step 1 compiler finds Animal so it will ignore All the Animal
   */
  println(mutant.name) // TIGER
}
