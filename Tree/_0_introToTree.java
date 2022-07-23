package Tree;

/*
    Tree Data Structure is used to organise data in hierarchical manner.
    node, root, leaf, child, parent, subtree, descendants, ancestors, degree and internal nodes.

    Apllication of tree DS:
        Used to represent Hierarchical manner
            Organised Structure
            Folder Structure
            XML/HTML Content (JSON Objects)
            In OOPS
        
        Binary Search Tree
        
        Binary Heap

        B and B+ in DBMS

        Spanning and Shortest Path tree in computer networks

        Parse Tree , Expression Tree in Complier

    Types of Tree:
        Trie
        Suffix Tree
        Binary Index Tree
        Segment Tree
*/

/*
    BINARY TREE
    Every node in a binary tree has atmost 2 children
*/

// public class Node {
//     int key;
//     Node left, right;

//     Node(int k) {
//         key = k;
//     }
// }

class TreeNode {
    int key;
    TreeNode left, right;

    TreeNode(int k) {
        key = k;
    }
}

class _0_introToTree {

    /*
     * Tree Taversal:
     * 
     * -Breadth First
     * -Depth First
     * In-Order (left root right)
     * Pre-Order (root left right)
     * Post-Order (left right root)
     */

    // Time complexity: O(n)
    // Space: O(h) H = (Height of tree + 1)

    static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    static void perOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.key + " ");
            perOrder(root.left);
            perOrder(root.right);
        }
    }

    static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Height of Binary Tree is the number of nodes between the longest path from
    // root to leaf node(including the root and leaf node).
    // Time: O(n) || Space: O(H) ,H = height of tree + 1;

    static int heigth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(heigth(root.left), heigth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(-7);
        root.right.left = new TreeNode(20);
        root.right.left.left = new TreeNode(15);

        inOrder(root);
        System.out.println();
        perOrder(root);
        System.out.println();
        postOrder(root);
        System.err.println();

        System.out.println("heigth: " + heigth(root));
    }
}