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
class TreeInfo{
    int maxi;
    int mini;
    int sum;
    int maxChildSum;

    public TreeInfo(int maxi, int mini, int sum, int maxChildSum){
        this.maxi = maxi;
        this.mini = mini;
        this.sum = sum;
        this.maxChildSum = maxChildSum;
    }
} 
class Solution {
    public TreeInfo findSum(TreeNode root){
        if(root == null){
            return new TreeInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        }
        TreeInfo left = findSum(root.left);
        TreeInfo right = findSum(root.right);
        if(left.maxi < root.val && right.mini > root.val){
            int sum = left.sum+right.sum+root.val;
            int maxSum = Math.max(sum, Math.max(left.maxChildSum, right.maxChildSum));
            return new TreeInfo(Math.max(right.maxi, root.val), Math.min(left.mini, root.val), sum, maxSum);
        }
        return new TreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.sum, right.sum), Math.max(right.maxChildSum, left.maxChildSum));
    }
    public int maxSumBST(TreeNode root) {
      TreeInfo ans = findSum(root);
      return Math.max(ans.sum, ans.maxChildSum);  
    }
}