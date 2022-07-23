package Tree;

/*
    Inorder conversion of Binary Tree to Doubly Linked List.
    A function that takes root of a Binary Tree and converts it into a Doubly linked list.
    Hint:- we need to do the inorder traversal of the Tree and while doing inorder traversal we can 
    simply maintain a previous pointer or reference of the previously traversed node. 
    And change right child of the previous node to current node and left child of current node as previous.
 */
class TreeNode {
    int key;
    TreeNode left, right;

    TreeNode(int k) {
        key = k;
    }
}

public class binaryToDoubleLL {

    static TreeNode prev = null;

    static TreeNode inorder(TreeNode root) {
        if (root == null)
            return root;
        TreeNode head = inorder(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        inorder(root.right);
        return head;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(11);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(13);
        root.left.right = new TreeNode(14);
        root.left.right.left = new TreeNode(17);
        root.left.right.right = new TreeNode(16);
        root.right.left = new TreeNode(15);
    
        TreeNode head = inorder(root);
        while (head != null) {
            System.out.println(head.key);
            head = head.right;
        }
    }   
}
