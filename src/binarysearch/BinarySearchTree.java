package binarysearch;

class Node{
    Node left;
    int data;
    Node right;
    Node(int data){
        this.data=data;
    }
}

public class BinarySearchTree {
    Node root;

    BinarySearchTree(Node root){
        this.root = root;
    }

    public void insert(int key) {
        Node leafNode = root;
        Node newNode = new Node(key);

        if (root == null) {
            root = newNode;
            return;
        }

        // Find leaf node
        while (leafNode != null) {
            if (leafNode.data == key) {
                return;
            } else if (leafNode.data > key) {
                if (leafNode.left == null) {
                    leafNode.left = newNode;
                    return;
                } else {
                    leafNode = leafNode.left;
                }
            } else {
                if (leafNode.right == null) {
                    leafNode.right = newNode;
                    return;
                } else {
                    leafNode = leafNode.right;
                }
            }
        }

    }

    // Function to delete a node from BST.
    // 노드 삭제 후 root 노드를 반환함.
    public Node deleteNode(Node root, int X) {
        if (root == null) return null;

        if (root.data > X) {
            root.left = deleteNode(root.left, X);
            return root;
        } else if (root.data < X) {
            root.right = deleteNode(root.right, X);
            return root;
        }

        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        // Find smallest node in right child tree
        Node succParent = root;
        Node succ = root.right;

        while (succ.left != null) {
            succParent = succ;
            succ = succ.left;
        }

        if (succParent == root) {
            root.right = succ.right;
        } else {
            succParent.left = succ.right;
        }

        root.data = succ.data;

        return root;
    }

    public void inorderTraversal(Node root) {
        if (root == null) return;

        // inorder traversal for left sub tree
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public void preOrderTraversal(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void postOrderTraversal(Node root) {
        if (root == null) return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }
}
