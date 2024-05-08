package generics


/*
 * Contravariance relation: 
 * Going towards upper_type of content is allowed
 * Going toward lower_type of content is not allowed
 */
class ContraVariant extends App {
   /*
    * contravariance relation:
    * Dog_Keeper can be Pet_Keeper
    * Dog_Keeper can also be a Animal_keeper
    */
   class Keeper[-A]
   val petKeeper: Keeper[Dog] = new Keeper[Pet]
   val animalKeeper: Keeper[Dog] = new Keeper[Animal]
   /*
    * Cat_Keeper can be a Cat_Keeper
    * their is no issue in This
    */
   val catKeeper: Keeper[Cat] = new Keeper[Cat]
   /*
    * Error: Found: Keeper[Dog] Required: Keeper[Pet]
    * Pet_Keeper can not be a Dog_Keeper
    * This is theoretically possible, but contravariance relation does not allow this
    */
   //val dogKeeper: Keeper[Pet] = new Keeper[Dog]
}
