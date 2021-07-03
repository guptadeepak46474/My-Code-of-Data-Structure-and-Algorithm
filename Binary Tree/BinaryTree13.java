// Print Ancestors of a given node in Binary Tree

public class BinaryTree13 {
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    Node root;
    boolean printAncestors(Node node, int target) {
        if(node == null)
            return false;
        if(node.data == target)
            return true;
        if(printAncestors(node.left, target) || printAncestors(node.right, target))
        {
            System.out.print(node.data + " ");
            return true;
        }
        return false;
    }
    public static void main(String args[]) 
    {
        BinaryTree13 tree = new BinaryTree13();
          
        /* Construct the following binary tree
                  1
                /   \
               2     3
              /  \
             4    5
            /
           7
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);
   
        tree.printAncestors(tree.root, 7);
   
    }
}

// Output
// 4 2 1