object Main extends App{

  // Testing TreeNode() class first:

  // Build Nodes
  var t0 = new TreeNode(key=0)
  var t1 = new TreeNode(key=1)
  var t2 = new TreeNode(key=2)
  var t3 = new TreeNode(key=3)
  var t4 = new TreeNode(key=4)
  var t5 = new TreeNode(key=5)

  // Unite them!
  t1.left = t0
  t0.parent = t1
  t1.right = t4
  t4.parent = t1
  t4.left = t2
  t2.parent = t4
  t4.right = t5
  t5.parent = t4
  t2.right = t3
  t3.parent = t2

  // Tree structure:
  //
  //         1
  //        / \
  //       0   4
  //          / \
  //         2   5
  //          \
  //           3

  // Test root function
  println("\n\n Root: ")
  println(t5.root)

  // every tree has a root, so this is NOT an Option(). but then the type of .root is different from the types of
  // .right, .left, .parent, .before, and .after, which all return Option[TreeNode]s. How do we feel about this?

  // Test .before method
  println("\n\nPreceeding nodes:")
  println(t0.before.getOrElse("None!"))
  println(t1.before.getOrElse("None!"))
  println(t2.before.getOrElse("None!"))
  println(t3.before.getOrElse("None!"))
  println(t4.before.getOrElse("None!"))
  println(t5.before.getOrElse("None!"))

  // Test .after method
  println("\n\nSubsequent nodes:")
  println(t0.after.getOrElse("None!"))
  println(t1.after.getOrElse("None!"))
  println(t2.after.getOrElse("None!"))
  println(t3.after.getOrElse("None!"))
  println(t4.after.getOrElse("None!"))
  println(t5.after.getOrElse("None!"))

  // Test BST class
  println("\n\nNow for some BST stuff.")

  var b = new BinarySearchTree()
  val keyList = List(1,4,2,5,0,3) // should give us the same tree as above
  val root = b.buildTree(keyList).get
  println(b.nodeList) // order here is arbitrary

  // inorder traversal should be in increasing order on a BST.
  // other traversals to not preserve any particular ordering.
  b.traverse(root)
  // check that our tree is what we expect
  println(root.right.get.left)

  // this should raise an exception:
  b.traverse(root, kind="outoforder")

}
