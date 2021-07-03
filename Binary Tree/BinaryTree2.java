// Iterative Queue based Java program
// to do level order traversal of Binary Tree

import java.util.*;
public class BinaryTree2 {
    static class Node {
        int data;
        Node left, right;
        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
    Node root;
    void printLevelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            
            if(tempNode.left != null)
                queue.add(tempNode.left);
            if(tempNode.right != null)
                queue.add(tempNode.right);
        }
    }
    public static void main(String args[])
    {
        /* creating a binary tree and entering
         the nodes */
        BinaryTree2 tree_level = new BinaryTree2();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);
 
        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrder();
    }
}

// Output
// Level order traversal of binary tree is - 
// 1 2 3 4 5