class BinarySearchTree {

  // is this a good example of a "constant"?
  val ValidTraversals = Set("inorder","preorder","postorder")
  // should these be camelCase?

  var nodeList: List[TreeNode] = Nil

  def buildTree(keyList: List[Int], parent:Option[TreeNode] = None): Option[TreeNode] = {
    // check if keys are unique

    if (keyList.length==0) {None}
    else {
      val pivot = keyList.head
      val node = new TreeNode(key = pivot)

      if (parent.isDefined) {
        node.parent = parent.get
      }

      // is this the way to do these comprehensions?
      val lessThan = for (item <- keyList if item < pivot) yield item
      val greaterThan = for (item <- keyList if item > pivot) yield item

      // This is kind of ugly... I'd like to be able to pass a None to my setter
      // and in that case just have it leave (for example) the left child as null.
      val _left = buildTree(keyList = lessThan, parent = Some(node))
      if (_left.isDefined) {
        node.left = _left.get
      }

      val _right = buildTree(keyList = greaterThan, parent = Some(node))
      if (_right.isDefined) {
        node.right = _right.get
      }

      nodeList = node :: nodeList // append node to graph's node list
      Option(node)
    }
  }

  def traverse(root: TreeNode, kind: String = "inorder"): Unit = {
    if (!ValidTraversals.contains(kind)) {
      throw new IllegalArgumentException("Invalid traversal type. Valid types are inorder, preorder, or postorder.")
    }
    if (kind=="preorder") {println(root)}
    if (root.left.isDefined) {traverse(root.left.get, kind = kind)}
    if (kind=="inorder") {println(root)}
    if (root.right.isDefined) {traverse(root.right.get, kind = kind)}
    if (kind=="postorder") {println(root)}
  }

  // A full implementation would have the ability to search (duh) as well as add and delete nodes from the tree.

}
