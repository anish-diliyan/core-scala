package singly_linked_list.simple_list

abstract class MyList {
    // first element of MyList
    def head: Int
    // all list except first element
    def tail: MyList
    // is list empty or not
    def isEmpty: Boolean
    // add element to head and return list
    def add(ele: Int): MyList

    def printElements: String

    override def toString: String = "[ " +printElements+ " ]"
}
