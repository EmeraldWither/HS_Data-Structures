/**
   This class implements a binary search tree whose
   nodes hold objects that implement the Comparable
   interface.
*/

public class BinarySeachTree
{
   private Node root;

   /**
      Constructs an empty tree.
   */
   public BinarySeachTree()
   {
      root = null;
   }

   /**
      Returns the smallest object in this tree
      @return the smallest object or null if the tree is empty
   */
 

   public Node getRoot()
   {
   		return root;
   }
 
   /**
      Inserts a new node into the tree.
      @param obj the object to insert
   */
   public void add(Comparable obj)
   {
      Node newNode = new Node();
      newNode.data = obj;
      newNode.left = null;
      newNode.right = null;
      if (root == null) root = newNode;
      else root.addNode(newNode);
   }

   /**
      Tries to find an object in the tree.
      @param obj the object to find
      @return true if the object is contained in the tree
   */
   public boolean find(Comparable obj)
   {
      Node current = root;
      while (current != null)
      {
         int d = current.data.compareTo(obj);
         if (d == 0) return true;
         else if (d > 0) current = current.left;
         else current = current.right;
      }
      return false;
   }

   /**
      Tries to remove an object from the tree. Does nothing
      if the object is not contained in the tree.
      @param obj the object to remove
   */
   public void remove(Comparable obj)
   {
      // Find node to be removed

      Node toBeRemoved = root;
      Node parent = null;
      boolean found = false;
      while (!found && toBeRemoved != null)
      {
         int d = toBeRemoved.data.compareTo(obj);
         if (d == 0) found = true;
         else
         {
            parent = toBeRemoved;
            if (d > 0) toBeRemoved = toBeRemoved.left;
            else toBeRemoved = toBeRemoved.right;
         }
      }

      if (!found) return;

      // toBeRemoved contains obj

      // If one of the children is empty, use the other

      if (toBeRemoved.left == null || toBeRemoved.right == null)
      {
         Node newChild;
         if (toBeRemoved.left == null)
            newChild = toBeRemoved.right;
         else
            newChild = toBeRemoved.left;

         if (parent == null) // Found in root
            root = newChild;
         else if (parent.left == toBeRemoved)
            parent.left = newChild;
         else
            parent.right = newChild;
         return;
      }

      // Neither subtree is empty

      // Find smallest element of the right subtree

      Node smallestParent = toBeRemoved;
      Node smallestNode = toBeRemoved.right;
      while (smallestNode.left != null)
      {
         smallestParent = smallestNode;
         smallestNode = smallestNode.left;
      }

      // smallestNode contains smallest child in right subtree

      // Move contents, unlink child

      toBeRemoved.data = smallestNode.data;
      smallestParent.left = smallestNode.right;
   }

   /**
      Prints the contents of the tree in sorted order.
   */
   public void print()
   {
      if (root != null)
         root.printNodes();
   }

   /**
      A node of a tree stores a data item and references
      of the child nodes to the left and to the right.
   */
   private class Node
   {
      public Comparable data;
      public Node left;
      public Node right;

 
      /**
         Inserts a new node as a descendant of this node.
         @param newNode the node to insert
      */
      public void addNode(Node newNode)
      {
         if (newNode.data.compareTo(data) < 0)
         {
            if (left == null) left = newNode;
            else left.addNode(newNode);
         }
         else
         {
            if (right == null) right = newNode;
            else right.addNode(newNode);
         }
      }

      /**
         Prints this node and all of its descendants
         in sorted order.
      */
      public void printNodes()
      {
         if (left != null)
            left.printNodes();
         System.out.println(data);
         if (right != null)
            right.printNodes();
      }
   }
   public Comparable getSmallest_itr() {
      Node n = root;
      while(n != null) {
         if(n.left == null) return n.data;
         n = n.left;
      }
      return null;
   }
   public Comparable getSmallest_rec() {
      return getSmallest_rec(root);
   }
   private Comparable getSmallest_rec(Node n) {
      if(n.left == null) return n.data;
      return getSmallest_rec(n.left);
   }

   public Comparable getLargest_itr() {
      Node n = root;
      while(n != null) {
         if(n.right == null) return n.data;
         n = n.right;
      }
      return null;
   }
   public Comparable getLargest_rec() {
      return getLargest_rec(root);
   }
   private Comparable getLargest_rec(Node n) {
      if(n.right == null) return n.data;
      return getLargest_rec(n.right);
   }
   public Integer sum() {
      return sum(root);
   }
   private Integer sum(Node n) {
      if(n == null) return 0;
      return (Integer) n.data + sum(n.left) + sum(n.right);
   }
}