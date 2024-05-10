package generics


/*
 * val fields: Covariant Position
 * var fields: Both Covariant and ContraVariant Position
 * method parameters: ContraVariant Position
 * method returns: Covariant Position
 * Rule 1: Covariant Parameter can not be used at Contravariant position
 * Rule 2: Contravariant Parameters can not be used at CoVariant Position
 */
object AdvancePositions extends App {
  // val fields are at Covariant position
  class CovariantCage[+T](val animal: T)
  //contravariant type T occurs in covariant position in type T of value animal
  //class ContraVariantCage[-T](val animal: T)
  class InvariantCage[T](val animal: T)


  //covariant type T occurs in contravariant position in type T of parameter animal_=
  //class CovariantVariableCage[+T](var animal: T)
  //contravariant type T occurs in covariant position in type T of variable animal
  //class ContraVariantVariableCage[-T](var animal: T)
  // var fields are both contravariant and covariant position
  // so only acceptable parameter type for var fields is InVariant
  class InvariantVariableCage[T](var animal: T)

  // method parameters are at contravariant position
  trait AnotherCovariantCage[+T] {
    //def addAnimal(animal: T) : T
  }

  // method return types are at covariant position
  trait AnotherContravariantCage[-T] {
    //def addAnimal(animal: T): T
  }
}
