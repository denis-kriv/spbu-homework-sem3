package homework3.hw3_task1

fun main() {
    var testHead = AvlTreeItem<Int, Int>(10, 10)
    var testChild1 = AvlTreeItem<Int, Int>(5, 5)
    var testChild2 = AvlTreeItem<Int, Int>(15, 15)
    var testChild3 = AvlTreeItem<Int, Int>(3, 3)
    var testChild4 = AvlTreeItem<Int, Int>(7, 7)
    var testChild5 = AvlTreeItem<Int, Int>(13, 13)
    var testChild6 = AvlTreeItem<Int, Int>(17, 17)
    var testChild7 = AvlTreeItem<Int, Int>(18, 18)
    /*var testChild8 = AvlTreeItem<Int, Int>(11, 18)
    var testChild9 = AvlTreeItem<Int, Int>(14, 14)
    var testChild10 = AvlTreeItem<Int, Int>(16, 16)
    var testChild11 = AvlTreeItem<Int, Int>(18, 18)
    var testChild12 = AvlTreeItem<Int, Int>(8, 8)*/
    var testTree = AvlTree<Int, Int>(testHead)
    testTree.plus(testChild1)
    testTree.plus(testChild2)
    testTree.minus(15)
    testTree.plus(testChild4)
    testTree.plus(testChild5)
    testTree.plus(testChild6)
    testTree.plus(testChild7)
    testTree.minus(13)
}