public class BinaryTree4 {
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    Node root;
    public void printInorder(Node root) {
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
    Node insertLevelOrder(int[] arr, Node root, int i) {
        if(i < arr.length) {
            // Node temp = new Node(arr[i]);
            // root = temp;
            root = new Node(arr[i]);

            // insert left child
            root.left = insertLevelOrder(arr, root.left, (2*i)+1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right, (2*i)+2);
        }
        return root;
    }
    public static void main(String args[])
    {
        BinaryTree4 t2 = new BinaryTree4();
        int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
        t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        t2.printInorder(t2.root);
    }
}

// Output
// 6 4 6 2 5 1 6 3 6