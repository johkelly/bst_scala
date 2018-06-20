# Binary Search Tree
### Peter Wills, June 2018

Included is my work on a lightweight implementation of a binary search tree in Scala. Some comments:

- The nodes of the tree and the tree itself are implemented in entirely separate classes. It might make more sense to implement the `TreeNode` class as a protected inner class of the `BinarySearchTree` class.
- Nodes can only take integer keys at the moment
- This is a very partial implementation - in particular, it can only build a BST from a list of keys, and traverse the resulting tree. A more complete implementation would include insertion, deletion, and of course searching the tree.


I've put comments throughout the code with my musings and confusions as I worked through this. Let's discuss more at the code review.