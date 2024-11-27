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
    int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int lheight = dfs(root.left);
        if(lheight == -1){
            return -1;
        }
        int rheight = dfs(root.right);
        if(rheight == -1){
            return -1;
        }
        if(dfs(root.left) - dfs(root.right)<=1 && dfs(root.left)-dfs(root.right)>=-1)
        return Math.max(lheight, rheight)+1;
        return -1;
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int lheight = dfs(root.left);
        int rheight = dfs(root.right);
        if(lheight == -1 || rheight == -1){
            return false;
        }
        if(dfs(root.left) - dfs(root.right)<=1 && dfs(root.left)-dfs(root.right)>=-1){
            return true;
        }
        return false;
    }
}