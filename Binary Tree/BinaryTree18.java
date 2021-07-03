/* Java program to contree using inorder and postorder traversals */
//Optimized approach: We can optimize the above solution using hashing (unordered_map in C++ or HashMap in Java). We store indexes of inorder 
//traversal in a hash table. So that search can be done O(1) time If given that element in the tree are not repeated.

import java.util.*;
public class BinaryTree18 {
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    static int index;
    static HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
    static Node buildTree(int[] in, int[] post, int len) {
        for(int i = 0; i < len; i++)
            mp.put(in[i], i);
        index = len-1;
        return buildUtil(in, post, 0, len-1);
    }
    
    static Node buildUtil(int[] in, int[] post, int inStrt, int inEnd) {
        if(inStrt > inEnd)
            return null;
        int curr = post[index--];
        Node node = new Node(curr);

        if(inStrt == inEnd)
            return node;
        
        int iIndex = mp.get(curr);
        node.right = buildUtil(in, post, iIndex+1, inEnd);
        node.left = buildUtil(in, post, inStrt, iIndex-1);

        return node;
    }

    static void preOrder(Node node)
    {
        if (node == null)
            return;
        System.out.printf("%d ", node.data);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void main(String[] args)
    {
        int in[] = { 4, 8, 2, 5, 1, 6, 3, 7 };
        int post[] = { 8, 4, 5, 2, 6, 7, 3, 1 };
        int n = in.length;
        Node root = buildTree(in, post, n);
        System.out.print("Preorder of the constructed tree : \n");
        preOrder(root);
    }
}

// Output
// Preorder of the constructed tree : 
// 1 2 4 8 5 3 6 7
// Time Complexity: O(n)