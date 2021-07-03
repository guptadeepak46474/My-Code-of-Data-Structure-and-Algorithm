// Java program for different tree traversals

public class BinaryTree3 {
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    Node root;
    void printPreorder(Node root) {
        if(root == null)
            return;
        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
    void printInorder(Node root) {
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
    void printPostorder(Node root) {
        if(root == null)
            return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data + " ");
    }
    public static void main(String[] args)
    {
        BinaryTree3 tree = new BinaryTree3();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        /*  1
           / \
          2   3
         / \
        4   5   */

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder(tree.root);
 
        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder(tree.root);
 
        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder(tree.root);
    }
}

// Output
// Preorder traversal of binary tree is 
// 1 2 4 5 3 
// Inorder traversal of binary tree is 
// 4 2 5 1 3 
// Postorder traversal of binary tree is
// 4 5 2 3 1