// Java program to implement Binary Search Tree (BST)

class BinarySearchTree {

    // Node structure for the Binary Search Tree
    class Node {
        int key;
        Node left, right;

        // Constructor
        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    private Node root;

    // Constructor
    public BinarySearchTree() {
        root = null;
    }

    // Method to insert a key into the BST
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Helper method to insert a key recursively
    private Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // Method to search a key in the BST
    public boolean search(int key) {
        return searchRec(root, key);
    }

    // Helper method to search a key recursively
    private boolean searchRec(Node root, int key) {
        // Base case: root is null or key is present at the root
        if (root == null) {
            return false;
        }

        // Key is greater than root's key
        if (key > root.key) {
            return searchRec(root.right, key);
        }

        // Key is smaller than root's key
        if (key < root.key) {
            return searchRec(root.left, key);
        }

        // Key is equal to root's key
        return true;
    }

    // Method to perform inorder traversal of the BST
    public void inorder() {
        inorderRec(root);
    }

    // Helper method for inorder traversal
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Main method to test the BST implementation
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert elements into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Inorder traversal (should print sorted order)
        System.out.println("Inorder traversal of the BST:");
        bst.inorder();

        // Search for a key in the BST
        int key = 40;
        System.out.println("\n\nIs " + key + " present in the BST? " + bst.search(key));

        key = 100;
        System.out.println("Is " + key + " present in the BST? " + bst.search(key));
    }
}
