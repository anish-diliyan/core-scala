package generics

/*
 * Covariance relation: 
 * Going towards upper_type of content is not allowed
 * Going toward lower_type of content is allowed
 */
object CoVariance extends App {
  /*
   * Pet_keeper can be Dog_Keeper
   * Pet_keeper can be Cat_Keeper
   */
  class Keeper[+A]
  val dogKeeper: Keeper[Pet] = new Keeper[Dog]
  val catKeeper: Keeper[Pet] = new Keeper[Cat]
  /*
   * Cat_Keeper can be a Cat_Keeper
   * their is no issue in This
   */
  val petKeeper: Keeper[Pet] = new Keeper[Pet]
  /*
   * Error: Found: Keeper[Animal] Required: Keeper[Pet]
   * Pet_Keeper can not be a Animal_Keeper
   * This is theoretically possible, but covariance relation does not allow this
   */
  //val animalKeeper: Keeper[Pet] = new Keeper[Animal]
}
