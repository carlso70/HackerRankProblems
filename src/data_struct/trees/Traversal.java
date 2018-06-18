package data_struct.trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Traversal {

    /* you only have to complete the function given below.
Node is defined as

class Node {
    int data;
    Node left;
    Node right;
}

*/

    public static void preOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    /**
     * You are given a pointer to the root of a binary tree.
     * You need to print the level order traversal of this tree.
     * In level order traversal, we visit the nodes level by level from left to right.
     * You only have to complete the function. For example:
     * <p>
     * 1
     * \
     * 2
     * \
     * 5
     * /  \
     * 3    6
     * \
     * 4
     * <p>
     * For the above tree, the level order traversal is 1 -> 2 -> 5 -> 3 -> 6 -> 4.
     *
     * @param root
     */
    public static void levelOrder(Node root) {
        // TODO look over this one, Breadth First Search
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            Node temp = queue.poll();
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);

            System.out.print(temp.data + " ");
        }

    }

    public static void descending(Node root) {
        if (root == null)
            return;

        if (root.right != null)
            postOrder(root.right);

        System.out.print(root.data + " ");

        if (root.left != null)
            postOrder(root.left);

    }

    public static void inOrder(Node root) {
        if (root == null)
            return;

        if (root.left != null)
            inOrder(root.left);

        System.out.print(root.data + " ");

        if (root.right != null)
            inOrder(root.right);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }


    public static int height(Node root) {
        if (root == null)
            return -1;

        int leftHt = 1 + height(root.left);
        int rightHt = 1 + height(root.right);

        if (leftHt > rightHt)
            return leftHt;
        return rightHt;
    }

    /**
     * You are given a pointer to the root of a binary tree. Print the top view of the binary tree.
     * Top view means when you look the tree from the top the nodes you will see will be called the top view of the tree. See the example below.
     * You only have to complete the function.
     * For example :
     * 1
     * \
     * 2
     * \
     * 5
     * /  \
     * 3    6
     * \
     * 4
     * <p>
     * Top View : 1 -> 2 -> 5 -> 6
     *
     * @param root
     */
    public static void topView(Node root) {
        topViewL(root.left);
        topViewR(root);
    }

    public static void topViewL(Node left) {
        if (left == null)
            return;
        topViewL(left.left);
        System.out.print(left.data + " ");
    }

    public static void topViewR(Node right) {
        if (right == null)
            return;
        System.out.print(right.data + " ");
        topViewR(right.right);
    }

    /**
     * You are given pointer to the root of the binary search tree and two values v1 and v2.
     * You need to return the lowest common ancestor (LCA) of  and  in the binary search tree.
     *
     * @param root
     * @param v1
     * @param v2
     */
    public static Node lca(Node root, int v1, int v2) {
        while (true) {
            if (root.data < v1 && root.data < v2)
                root = root.right;
            else if (root.data > v1 && root.data > v2)
                root = root.left;
            else
                return root;
        }
    }

    /**
     * Given the root node, define if it's a Binary Search Tree, all nodes left are < node above
     * All nodes right are > node above
     *
     * @param root
     * @return
     */
    public static boolean checkBST(Node root) {
        // Traverse whole tree using BFS
        Queue<Node> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node temp = list.poll();
            if (temp.left != null) {
                list.add(temp.left);
                System.out.println("Current temp = " + temp.data + ", temp.left = " + temp.left.data);
                if (temp.data <= temp.left.data)
                    return false;
            }
            if (temp.right != null) {
                list.add(temp.right);
                System.out.println("Current temp = " + temp.data + ", temp.right = " + temp.right.data);
                if (temp.data >= temp.right.data)
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("./src/data_struct/trees/is-binary-search-tree-testcases/input/input00.txt");
        Scanner scan = new Scanner(f);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        System.out.print("PreOrder: ");
        preOrder(root);
        System.out.print("\n\nPost Order: ");
        postOrder(root);
        System.out.print("\n\nIn Order: ");
        inOrder(root);
        System.out.print("\n\nHeight: ");
        System.out.print(height(root));
        System.out.print("\n\nTop View: ");
        topView(root);
        System.out.print("\n\nLevel Order: ");
        levelOrder(root);
        System.out.println("\n\nIs BST?");
        System.out.println(checkBST(root));
    }
}