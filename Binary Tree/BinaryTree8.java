// Write a Program to Find the Maximum Depth or Height of a Tree

public class BinaryTree8 {
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    Node root;
    int maxDepth(Node node) {
        if(node == null)
            return 0;
        int lDepth = maxDepth(node.left);
        int rDepth = maxDepth(node.right);
        if(lDepth > rDepth)
            return (lDepth+1);
        else
            return (rDepth+1);
    }
    public static void main(String[] args)
    {
        BinaryTree8 tree = new BinaryTree8();
  
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
  
        System.out.println("Height of tree is : " + tree.maxDepth(tree.root));
    }
}

// Output
// Height of tree is : 3