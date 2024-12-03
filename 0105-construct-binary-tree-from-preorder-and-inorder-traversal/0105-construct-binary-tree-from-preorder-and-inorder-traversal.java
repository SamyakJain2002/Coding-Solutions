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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        int preIdx = 1, inIdx = 0;
        st.push(root);
        while (preIdx != preorder.length) {
            TreeNode curr = st.peek();
            if (st.peek().val != inorder[inIdx]) {
                curr.left = new TreeNode(preorder[preIdx]);
                preIdx++;
                st.push(curr.left);
            } else {
                while (!st.empty() && st.peek().val == inorder[inIdx]) {
                    curr = st.pop();
                    inIdx++;
                }
                curr.right = new TreeNode(preorder[preIdx]);
                preIdx++;
                st.push(curr.right);
            }
        }
        return root;
    }
}