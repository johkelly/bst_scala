// Port of my implementation of a Binary Search Tree from python.

class TreeNode (var key: Int,
                private var _parent: TreeNode = null,
                private var _left: TreeNode = null,
                private var _right: TreeNode = null) {

  // We want to override the default getters and setters, so that the getters return an option but the setters take a TreeNode (not an Option[TreeNode]) as an argument. Perhaps a better approach is to define an empty node, and use it as the default for all these things, rather than trying to use None.

  // override default getters to handle possible null values
  def parent: Option[TreeNode] = Option(_parent)
  def left: Option[TreeNode] = Option(_left)
  def right: Option[TreeNode] = Option(_right)

  // override default getters so that TreeNodes can be input directly
  def parent_=(input: TreeNode) {
    _parent = input
  }
  def left_=(input: TreeNode) {
    _left = input
  }
  def right_=(input: TreeNode) {
    _right = input
  }

  // print the node as its key
  override def toString: String = "Node <" + key.toString + ">"

  def root(): TreeNode = {
    var walk = this
    // should I say var walk: TreeNode = this? Or is it acceptable to omit the type here?
    while (walk.parent.isDefined) {
      walk = walk.parent.get
    }
    walk
  }

  def before(): Option[TreeNode] = {
    // if node has a left child, then previous node is rightmost node
    // in left subtree
    if (this.left.isDefined) {
      var walk = this.left.get
      while (walk.right.isDefined) {
        walk = walk.right.get
      }
      Option(walk) // here's my first "return" statement
    }
    else {
      if (this.parent.isDefined) {
        var walk = this
        // below should be "while you are your parent's left child"
        while (walk.parent.isDefined
          && walk.parent.get.left.isDefined
          && walk == walk.parent.get.left.get) {
          // the above (walk.parent.get.left.get) is super ugly, because we have to include so many .gets. I think this
          // is an unavoidable byproduct of static typing though, since we want to allow these things to be None.
          walk = walk.parent.get
        }
        if (walk.parent.isDefined) {
          walk.parent
        }
        else None
      }
      else None // return none if no left child and no parent
    }
  }

  def after(): Option[TreeNode] = {
    if (this.right.isDefined) {
      var walk = this.right.get
      while (walk.left.isDefined) {
        walk = walk.left.get
      }
      Option(walk)
    }
    else {
      if (this.parent.isDefined) {
        var walk = this
        while (walk.parent.isDefined
          && walk.parent.get.right.isDefined
          && walk == walk.parent.get.right.get) { // so ugly!
          walk = walk.parent.get
        }
        if (walk.parent.isDefined) {
          walk.parent
        }
        else None
      }
      else None // return none if no left child and no parent
    }
  }

}