// Java program to print inorder
// traversal without recursion and stack

public class BinaryTree7 {
    static class tNode {
        int data;
        tNode left, right;
    
        tNode(int item)
        {
            data = item;
            left = right = null;
        }
    }
    tNode root;
    void MorrisTraversal(tNode root) {
        tNode current, pre;
        if(root == null)
            return;
        current = root;
        while(current != null) 
        {
            if(current.left == null) 
            {
                System.out.print(current.data + " ");
                current = current.right;
            }
            else
            {
                pre = current.left;
                while(pre.right != null && pre.right != current)
                    pre = pre.right;
                if(pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }
                else
                {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }
    public static void main(String args[])
    {
        /* Constructed binary tree is
               1
             /   \
            2      3
          /   \
         4     5
        */
        BinaryTree7 tree = new BinaryTree7();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
 
        tree.MorrisTraversal(tree.root);
    }
}

// Output
// 4 2 5 1 3