package problems
import scala.util.Random

/** Definition for singly-linked list. class ListNode(_x: Int = 0, _next: ListNode = null) { var
  * next: ListNode = _next var x: Int = _x }
  */
class LinkedListRandomNode(_head: ListNode) {
  def getRandom(): Int = {
    val size        = listSize(_head)
    val randomIndex = indexFromSize(size)
    getIndexedValue(_head, randomIndex)
  }

  private def listSize(head: ListNode): Int = {
    if (head == null) return -1

    var size = 1
    var node = head

    while (node.next != null) {
      node = node.next
      size += 1
    }

    size
  }

  private def indexFromSize(size: Int): Int = {
    Random.nextInt(size)
  }

  private def getIndexedValue(head: ListNode, index: Int): Int = {
    var node = head

    for (i <- 0 until index) {
      node = node.next
    }

    node.x
  }
}

/** Your Solution object will be instantiated and called as such: var obj = new Solution(head) var
  * param_1 = obj.getRandom()
  */
