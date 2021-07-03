/* Java program to construct tree using inorder and preorder traversals */
// Efficient Approach : We can optimize the above solution using hashing (unordered_map in C++ or HashMap in Java). We store indexes of inorder traversal in a hash table. So that search can be done O(1) time.

import java.util.*;

public class BinaryTree10 {
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static Node root;
    static HashMap<Integer, Integer> mp = new HashMap<>();
    static int preIndex = 0;

    Node buildTree(int[] in, int[] pre, int inStrt, int inEnd) {
        if(inStrt > inEnd)
            return null;
        Node tNode = new Node(pre[preIndex++]);
        if(inStrt == inEnd)
            return tNode;
        
        int inIndex = search(in, inStrt, inEnd, tNode.data);

        tNode.left = buildTree(in, pre, inStrt, inIndex-1);
        tNode.right = buildTree(in, pre, inIndex+1, inEnd);

        return tNode;
    }
    int search(int[] arr, int strt, int end, int value) {
        int i;
        for(i = strt; i <= end; i++)
            if(arr[i] == value)
                return i;
        return i;
    }
    /* This funtcion is here just to test buildTree() */
    void printInorder(Node node) {
        if(node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
    Node buildTreeWrap(int[] inOrder, int[] preOrder, int len)
    {
        for(int i = 0; i < len; i++)
            mp.put(inOrder[i], i);
        return buildTree(inOrder, preOrder, 0, len-1);
    }
    public static void main(String[] args) {
        BinaryTree10 tree = new BinaryTree10();
        int[] preOrder = new int[] {1,2,4,8,9,10,11,5,3,6,7};
        int[] inOrder = new int[] {8,4,10,9,11,2,5,1,6,3,7};
        int len = inOrder.length;
        
        root = tree.buildTreeWrap(inOrder, preOrder, len);

        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }
}

// Output
// Inorder traversal of constructed tree is : 
// 8 4 10 9 11 2 5 1 6 3 7 