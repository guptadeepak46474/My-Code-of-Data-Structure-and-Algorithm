// Recursive Java program for level order traversal of Binary Tree
/* Class containing left and right child of current
   node and key value*/

public class BinaryTree1 {
    static class Node {
        int data;
        Node left, right;
        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
    Node root;
    public BinaryTree1() {
        root = null;
    }
    void printLevelOrder() {
        int h = height(root);
        for(int i = 1; i <= h; i++)
            printCurrentLeval(root, i);
    }
    void printCurrentLeval(Node root, int level) {
        if(root == null)
            return;
        if(level == 1)
            System.out.print(root.data + " ");
        else if(level > 1) {
            printCurrentLeval(root.left, level-1);
            printCurrentLeval(root.right, level-1);
        }
    }
    int height(Node root) {
        if(root == null)
            return 0;
        else
        {
            int lheight = height(root.left);
            int rheight = height(root.right);
            
            /* use the large one */
            if(lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
    public static void main(String args[])
    {
       BinaryTree1 tree = new BinaryTree1();
       tree.root= new Node(1);
       tree.root.left= new Node(2);
       tree.root.right= new Node(3);
       tree.root.left.left= new Node(4);
       tree.root.left.right= new Node(5);

       /* 
            1
           / \
          2    3
         / \
        4   5 
        
        */
        
       System.out.println("Level order traversal of binary tree is ");
       tree.printLevelOrder();
    }
}

// Output
// Level order traversal of binary tree is 
// 1 2 3 4 5