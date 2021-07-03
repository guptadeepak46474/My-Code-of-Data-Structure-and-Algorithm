// Check if a binary tree is subtree of another binary tree | Set 1

public class BinaryTree14 {
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    Node root1, root2;
    boolean isSubtree(Node T, Node S) {
        if(S == null)
            return true;
        if(T == null)
            return false;
        if(areIdentical(T, S))
            return true;
        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }
    boolean areIdentical(Node root1, Node root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        return (root1.data == root2.data 
                && areIdentical(root1.left, root2.left) 
                && areIdentical(root1.right, root2.right));
    }
    public static void main(String args[])
    {
        BinaryTree14 tree = new BinaryTree14();
          
        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */
           
        tree.root1 = new Node(26);
        tree.root1.right = new Node(3);
        tree.root1.right.right = new Node(3);
        tree.root1.left = new Node(10);
        tree.root1.left.left = new Node(4);
        tree.root1.left.left.right = new Node(30);
        tree.root1.left.right = new Node(6);
  
        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */
           
        tree.root2 = new Node(10);
        tree.root2.right = new Node(6);
        tree.root2.left = new Node(4);
        tree.root2.left.right = new Node(30);
  
        if (tree.isSubtree(tree.root1, tree.root2))
            System.out.println("Tree 2 is subtree of Tree 1 ");
        else
            System.out.println("Tree 2 is not a subtree of Tree 1");
    }
}

// Output
// Tree 2 is subtree of Tree 1