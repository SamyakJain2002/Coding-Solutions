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
    int maxi  = 0;
    int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        maxi = Math.max(leftDepth+rightDepth, maxi);
        return Math.max(leftDepth, rightDepth)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxi;
    }
}