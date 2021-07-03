// Construct Full Binary Tree from given preorder and postorder traversals

public class BinaryTree16 {
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    static int preindex = 0;
    static Node constructTreeUtil(int[] pre, int[] post, int l, int h, int size) {
        if(preindex >= size || l > h)
            return null;
        Node root = new Node(pre[preindex++]);
        if(l == h || preindex >= size)
            return root;
        int i;
        for(i = l; i <= h; i++) {
            if(post[i] == pre[preindex])
                break;
        }
        if(i <= h)
        {
            root.left = constructTreeUtil(pre, post, l, i, size);
            root.right = constructTreeUtil(pre, post, i+1, h, size);
        }
        return root;
    }
    static void printInorder(Node root) {
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
    public static void main(String[] args)
    {
 
        int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
        int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };
 
        int size = pre.length;
        Node root = constructTreeUtil(pre, post, 0, size-1, size);
 
        System.out.println("Inorder traversal of the constructed tree:");
        printInorder(root);
    }
}

// Output
// Inorder traversal of the constructed tree:
// 8 4 9 2 5 1 6 3 7