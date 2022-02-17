package binarysearch.study;

public class Executor {

    public static void main(String args[]) {
        executeBinarySearchTree();
    }

    private static void executeBinarySearchTree() {
         /* Let us create following BST
                  50
                /     \
               30     70
              / \    / \
             20 40  60 80
                  \
                  45
                 /
               42
         */
        Node root = null;
        BinarySearchTree binarySearchTree = new BinarySearchTree(root);
        binarySearchTree.insert(50);
        binarySearchTree.insert(50);
        binarySearchTree.insert(30);
        binarySearchTree.insert(20);
        binarySearchTree.insert(40);
        binarySearchTree.insert(70);
        binarySearchTree.insert(60);
        binarySearchTree.insert(80);
        binarySearchTree.insert(45);
        binarySearchTree.insert(42);

        System.out.println("After inserting");
        binarySearchTree.inorderTraversal(binarySearchTree.root);

        /* After removing 30
                  50
                /     \
               40     70
              / \    / \
             20 45  60 80
               /
              42
         */
        binarySearchTree.deleteNode(binarySearchTree.root, 30);
        System.out.println("\nAfter deleting 30");
        binarySearchTree.inorderTraversal(binarySearchTree.root);

        /* After removing 45
                  50
                /     \
               40     70
              / \    / \
             20 42  60 80
             40
            / \
            33
         */
        binarySearchTree.deleteNode(binarySearchTree.root, 45);
        System.out.println("\nAfter deleting 45");
        binarySearchTree.inorderTraversal(binarySearchTree.root);

          /* After removing 20
                  50
                /     \
               40     70
                \    / \
                42  60 80
         */
        binarySearchTree.deleteNode(binarySearchTree.root, 20);
        System.out.println("\nAfter deleting 20");
        binarySearchTree.inorderTraversal(binarySearchTree.root);
        System.out.println();

        // 50 - 40 - 42 - 70 - 60 - 80
        System.out.println("Preorder Traversal");
        binarySearchTree.preOrderTraversal(binarySearchTree.root);
        System.out.println();

        // 42 - 40 - 60 - 80 - 70 - 50
        System.out.println("Postorder Traversal");
        binarySearchTree.postOrderTraversal(binarySearchTree.root);
    }
}
