package problems

/** Link to problem https://leetcode.com/problems/search-in-a-binary-search-tree */
object SearchBST {

  /** Definition for a binary tree node. class TreeNode(_value: Int = 0, _left: TreeNode = null,
    * _right: TreeNode = null) { var value: Int = _value var left: TreeNode = _left var right:
    * TreeNode = _right }
    */
  def searchBST(root: TreeNode, `val`: Int): TreeNode = {
    if (root == null) return null

    root.value match {
      case `val`          => root
      case n if n > `val` => searchBST(root.left, `val`)
      case n if n < `val` => searchBST(root.right, `val`)
    }
  }

}

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int      = _value
  var left: TreeNode  = _left
  var right: TreeNode = _right
}
