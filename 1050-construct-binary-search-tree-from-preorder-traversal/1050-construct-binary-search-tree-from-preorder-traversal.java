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
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        int idx = 1;
        st.push(root);
        while(idx<preorder.length){
            TreeNode curr = st.pop();
            TreeNode prev = null;
            while(!st.empty() && curr.val < preorder[idx]){
                prev = curr;
                curr = st.pop();
            }
            if(curr.val < preorder[idx]){
                curr.right = new TreeNode(preorder[idx]);
                st.push(curr.right);
            }else{
                TreeNode newNode = new TreeNode(preorder[idx]);
                if(prev != null){
                    prev.right = newNode;
                }else{
                    curr.left = newNode;
                }
                st.push(curr);
                st.push(newNode);
            }
            idx++;
        }
        return root;
    }
}