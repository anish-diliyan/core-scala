package generics

class ContraVariant extends App{
   class Keeper[-A]
   class ZooKeeper extends Keeper[Animal]
   class PetSitter extends Keeper[Pet]
   class DogSitter extends Keeper[Dog]

   val ds: Keeper[Dog] = new DogSitter
   val zoo: Keeper[Dog] = new ZooKeeper
   //val petKpr: Keeper[Pet] = new DogSitter
}
