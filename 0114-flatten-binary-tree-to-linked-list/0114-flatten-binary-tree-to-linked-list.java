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
    public TreeNode findLast(TreeNode root){
        if(root.left == null && root.right == null){
            return root;
        }
        if(root.left == null){
            return findLast(root.right);
        }
        TreeNode temp = root.right;
        TreeNode fend = findLast(root.left);
        root.right = root.left;
        root.left = null;
        fend.right = temp;
        if(temp != null){
            return findLast(temp);
        }
        return fend;
    }
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        findLast(root);

    }
}