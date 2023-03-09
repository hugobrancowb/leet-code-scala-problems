package problems
import scala.annotation.tailrec

/** Link to the problem: https://leetcode.com/problems/linked-list-cycle-ii */
object DetectCycle {
  def detectCycle(head: ListNode): ListNode = {
    val cyclePoint = findCycle(Array(), head)

    cyclePoint match {
      case Some(x) => x
      case None    => null
    }
  }

  private def findCycle(
    listNodes: Array[ListNode],
    currentNode: ListNode
  ): Option[ListNode] = {
    if (currentNode == null) return None

    val cycleNode = listNodes.find(n => n == currentNode)

    if (cycleNode.isDefined) return cycleNode

    if (currentNode.next == null) return None

    val newList = listNodes.appended(currentNode)

    findCycle(newList, currentNode.next)
  }
}

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int         = _x
}
