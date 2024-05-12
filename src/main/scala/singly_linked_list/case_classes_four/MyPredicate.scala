package singly_linked_list.case_classes_four

trait MyPredicate[-T] {
   def test(ele: T): Boolean
}
