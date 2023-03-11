package problems

/** Link to the problem https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree */

/** Definition for singly-linked list. class ListNode(_x: Int = 0, _next: ListNode = null) { var
  * next: ListNode = _next var x: Int = _x }
  */
/** Definition for a binary tree node. class TreeNode(_value: Int = 0, _left: TreeNode = null,
  * _right: TreeNode = null) { var value: Int = _value var left: TreeNode = _left var right:
  * TreeNode = _right }
  */
object SortedListToBST {
  def sortedListToBST(head: ListNode): TreeNode = {
    val array = buildArray(head)
    buildTree(buildArray(head), 0, array.length - 1)
  }

  private def buildArray(head: ListNode): Array[Int] = {
    if (head == null) return Array()

    var currentNode: ListNode = head
    var nextNode: ListNode    = head.next
    var list                  = Array[Int]()

    while (currentNode.next != null) {
      list = list.appended(currentNode.x)
      currentNode = currentNode.next
      nextNode = currentNode.next
    }

    list.appended(currentNode.x)
  }

  private def buildTree(array: Array[Int], left: Int, right: Int): TreeNode = {
    if (left > right) return null

    val mid       = Math.ceil((left + right) / 2).toInt
    val rootNode  = array(mid)
    val rightNode = buildTree(array, mid + 1, right)
    val leftNode  = buildTree(array, left, mid - 1)

    new TreeNode(rootNode, leftNode, rightNode)
  }
}
