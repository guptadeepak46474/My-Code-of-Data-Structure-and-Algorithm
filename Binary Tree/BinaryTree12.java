// Print nodes at k distance from root

public class BinaryTree12 {
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    Node root;
    void printKDistant(Node node, int k) {
        if(node == null || k < 0)
            return;
        if(k == 0) {
            System.out.print(node.data + " ");
            return;
        }
        //recursively traversing
        printKDistant(node.left, k-1);
        printKDistant(node.right, k-1);
    }
    public static void main(String args[]) {
        BinaryTree12 tree = new BinaryTree12();
         
        /* Constructed binary tree is
                1
              /   \
             2     3
            /  \   /
           4    5 8
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(8);
  
        tree.printKDistant(tree.root, 2);
    }
}

// Output
// 4 5 8