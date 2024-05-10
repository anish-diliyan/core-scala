package singly_linked_list.add_mthods

trait MyTransformer[-A, B] {
  def transform(ele: A): B
}
