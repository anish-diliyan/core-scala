package generics

/*
 * Invariance relation: 
 * Going towards upper_type of content is not allowed
 * Going toward lower_type of content is not allowed
 * We can only have Same type of content
 */
object InVariance extends App {

  class Keeper[A]
  /*
   * Error: Found: Keeper[Dog] Required: Keeper[Pet]
   * Pet_keeper can not be Dog_Keeper
   * This is theoretically possible, but Invariance relation does not allow this
   */  
  //val dogKeeper: Keeper[Pet] = new Keeper[Dog]
  /*
   * Pet_Keeper can be a Pet_Keeper
   * their is no issue in This
   */
  val petKeeper: Keeper[Pet] = new Keeper[Pet]
  /*
   * Error: Found: Keeper[Animal] Required: Keeper[Pet]
   * Pet_Keeper can not be a Animal_Keeper
   * This is theoretically possible, but Invariance relation does not allow this
   */
  //val animalKeeper: Keeper[Pet] = new Keeper[Animal]
}
