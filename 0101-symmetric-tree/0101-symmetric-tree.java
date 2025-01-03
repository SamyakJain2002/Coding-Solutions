/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   private boolean isSymmetricUtil(TreeNode root1, TreeNode root2) {
        // Check if either subtree is null
        if (root1 == null || root2 == null) {
            // If one subtree is null, the other
            // must also be null for symmetry
            return root1 == root2;
        }
        // Check if the data in the current nodes is equal
        // and recursively check for symmetry in subtrees
        return (root1.val == root2.val)
                && isSymmetricUtil(root1.left, root2.right)
                && isSymmetricUtil(root1.right, root2.left);
    }

    // Public function to check if the
    // entire binary tree is symmetric
    public boolean isSymmetric(TreeNode root) {
        // Check if the tree is empty
        if (root == null) {
            // An empty tree is
            // considered symmetric
            return true;
        }
        // Call the utility function
        // to check symmetry of subtrees
        return isSymmetricUtil(root.left, root.right);
    }
}