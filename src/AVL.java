// Java program to demonstrate AVL Tree operations (Insert, Balance, Rotate)

class AVLTree {
    // Node structure for the AVL Tree
    class Node {
        int key;
        Node left, right;
        int height;

        // Constructor
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
            // Duplicate keys are not allowed
            return node;
        }

        // Update the height of this node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor to check whether this node became unbalanced
        int balance = balanceFactor(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case (Right rotation)
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        // Right Right Case (Left rotation)
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        // Left Right Case (Left-Right rotation)
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case (Right-Left rotation)
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the (unchanged) node pointer
        return node;
    }

    // Public method to insert a key into the AVL tree
    public void insert(int key) {
        root = insert(root, key);
    }

    // Preorder traversal of the tree
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Public method to do preOrder traversal
    public void preOrder() {
        preOrder(root);
    }

    // Main method to test the AVL Tree implementation
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Insert nodes into the AVL tree
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(15);
        tree.insert(25);
        tree.insert(5);

        // Display preorder traversal of the tree
        System.out.println("Preorder traversal of the AVL tree:");
        tree.preOrder();
    }
}
