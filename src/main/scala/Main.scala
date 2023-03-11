import problems.{ListNode, _}
object Main extends App {
  println("-" * 30)

  val list           = Array(-10, -3, 0, 5, 9).reverse
  var head: ListNode = null

  for (num <- list) {
    val newNode = new ListNode(num)

    if (head == null) {
      head = newNode
    } else {
      newNode.next = head
      head = newNode
    }
  }

  Array(
    SortedListToBST.sortedListToBST(head)
  ).foreach(println)

  println("-" * 30)
}
