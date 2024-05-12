package singly_linked_list.case_classes_four

trait MyTransformer[-A, B] {
  def transform(ele: A): B
}
