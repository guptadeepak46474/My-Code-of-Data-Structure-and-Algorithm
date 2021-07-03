// Inorder Tree Traversal without Recursion

import java.util.*;
public class BinaryTree6 {
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    Node root;
    void inorder() {
        if(root == null)
            return;
        Stack<Node> s = new Stack<Node>();
        Node curr = root;
        // traverse the tree
        while(curr != null || s.size() > 0) {
            /* Reach the left most Node of the
            curr Node */
            while(curr != null) {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                s.push(curr);
                curr = curr.left;
            }
            /* Current must be NULL at this point */
            curr = s.pop();
            System.out.print(curr.data + " ");
            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            curr = curr.right;
        }
    }
    public static void main(String args[])
    {
        /* creating a binary tree and entering
        the nodes */
        BinaryTree6 tree = new BinaryTree6();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inorder();
    }
}

// Output
// 4 2 5 1 3