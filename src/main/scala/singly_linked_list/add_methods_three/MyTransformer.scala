package singly_linked_list.add_methods_three

trait MyTransformer[-A, B] {
  def transform(ele: A): B
}
