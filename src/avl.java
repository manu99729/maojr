import java.util.*;

// AVL Tree Class
class AVLTree {
    // Node structure for the AVL Tree
    class Node {
        int key;
        Node left, right;
        int height;

        Node(int key) {
            this.key = key;
            left = right = null;
            height = 1;
        }
    }

    private Node root;

    // Get the height of the node
    int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    // Get the balance factor of the node
    int balanceFactor(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    // Right rotate subtree rooted with node
    Node rightRotate(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;

        // Update heights
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;

        return newRoot;
    }

    // Left rotate subtree rooted with node
    Node leftRotate(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;

        // Update heights
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;

        return newRoot;
    }

    // Insert a node into the AVL tree
    Node insert(Node node, int key) {
        if (node == null) return new Node(key);

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node; // Duplicates are not allowed
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = balanceFactor(node);

        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Public method to insert a key
    public void insert(int key) {
        root = insert(root, key);
    }

    // Inorder traversal of the AVL tree to get sorted values
    void inorder(Node node, List<Integer> result) {
        if (node != null) {
            inorder(node.left, result);
            result.add(node.key);
            inorder(node.right, result);
        }
    }

    // Public method to perform inorder traversal and return sorted list
    public List<Integer> inorder() {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    // Main method to test AVL sorting
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Array to be sorted
        int[] array = { 50, 30, 20, 40, 70, 60, 80 };

        // Insert elements into the AVL tree
        for (int value : array) {
            tree.insert(value);
        }

        // Get sorted result from inorder traversal
        List<Integer> sortedList = tree.inorder();

        // Print sorted result
        System.out.println("Sorted array using AVL tree:");
        for (int val : sortedList) {
            System.out.print(val + " ");
        }
    }
}
