// Construct a Binary Tree from Postorder and Inorder

public class BinaryTree17 {
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    Node buildUtil(int[] in, int[] post, int inStrt, int inEnd, int postStrt, int postEnd) {
        if(inStrt > inEnd)
            return null;
        Node node = new Node(post[postEnd]);
        if(inStrt == inEnd)
            return node;
        int iIndex = search(in, inStrt, inEnd, node.data);
        
        node.left = buildUtil(in, post, inStrt, iIndex-1, postStrt, postStrt - inStrt + iIndex - 1);
        node.right = buildUtil(in, post, iIndex+1, inEnd, postEnd - inEnd + iIndex, postEnd-1);

        return node;
    }
    int search(int[] in, int strt, int end, int value) {
        int i;
        for(i = strt; i < end; i++)
            if(in[i] == value)
                break;
        return i;
    }
    /* This funtcion is here just to test  */
    void preOrder(Node node)
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void main(String[] args)
    {
        BinaryTree17 tree = new BinaryTree17();
        int in[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
        int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 };
        int n = in.length;
        Node root
            = tree.buildUtil(in, post, 0, n - 1, 0, n - 1);
        System.out.println(
            "Preorder of the constructed tree : ");
        tree.preOrder(root);
    }
}

// Output
// Preorder of the constructed tree : 
// 1 2 4 8 5 3 6 7
// Time Complexity: O(n2)