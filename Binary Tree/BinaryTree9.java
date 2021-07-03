// Construct Tree from given Inorder and Preorder traversals

public class BinaryTree9 {
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    Node root;
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
    public static void main(String[] args) {
        BinaryTree9 tree = new BinaryTree9();
        int[] preOrder = new int[] {1,2,4,8,9,10,11,5,3,6,7};
        int[] inOrder = new int[] {8,4,10,9,11,2,5,1,6,3,7};
        int len = inOrder.length;
        Node root = tree.buildTree(inOrder, preOrder, 0, len-1);

        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }
}

// Output
// Inorder traversal of constructed tree is : 
// 8 4 10 9 11 2 5 1 6 3 7