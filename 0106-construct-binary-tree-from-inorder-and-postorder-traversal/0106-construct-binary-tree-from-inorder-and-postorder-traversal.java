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
    public TreeNode makeTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd, Map<Integer,Integer> mp){
        if(inStart > inEnd || postEnd < 0){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int idx = mp.get(root.val);
        root.right = makeTree(inorder, postorder, idx+1, inEnd, postEnd-1, mp);
        root.left = makeTree(inorder, postorder, inStart, idx-1, postEnd-inEnd+idx-1, mp);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i], i);
        }
        TreeNode root = makeTree(inorder, postorder, 0, inorder.length-1, postorder.length-1, mp);
        return root;
    }
}