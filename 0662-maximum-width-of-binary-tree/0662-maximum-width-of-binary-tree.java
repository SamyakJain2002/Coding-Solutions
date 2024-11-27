/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxi = 1;
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            int n = q.size();
            int maxDis = 0;
            int minDis = 0;
            for (int i = 1; i <= n; i++) {
                Pair<TreeNode, Integer> curr = q.poll();
                root = curr.getKey();
                int dis = curr.getValue();
                if(i==1){
                    minDis = dis;
                }
                if(i==n){
                    maxDis = dis;
                }
                if(root.left!=null){
                    q.add(new Pair(root.left, 2*dis+1));
                }
                if(root.right!=null){
                    q.add(new Pair(root.right, 2*dis+2));
                }
            }
            int diff = maxDis - minDis+1;
            maxi = Math.max(maxi, diff);
        }
        return maxi;
    }
}