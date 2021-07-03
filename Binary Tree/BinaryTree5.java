// Recursive optimized Java program to find the diameter of a Binary Tree
// Class containing left and right child of current node and key value

public class BinaryTree5 {
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    Node root;
    int diameter(Node root) {
        if(root == null)
            return 0;
        
        int lheight = height(root.left);
        int rheight = height(root.right);

        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        return Math.max(lheight + rheight + 1, Math.max(ldiameter,rdiameter));
    }
    int height(Node node) {
        if(node == null)
            return 0;
        
        return (1+Math.max(height(node.left), height(node.right)));
    }
    public static void main(String args[])
    {
        // creating a binary tree and entering the nodes
        BinaryTree5 tree = new BinaryTree5();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        // Function Call
        System.out.println(
            "The diameter of given binary tree is : " + tree.diameter(tree.root));
    }
}

// Output
// The diameter of given binary tree is : 4