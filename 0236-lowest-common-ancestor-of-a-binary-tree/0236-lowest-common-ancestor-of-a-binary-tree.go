/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func isNodeFound(root, p, q, ans *TreeNode) bool {
	if root == nil {
		return false
	}
	isCurrentNeeded := false
	if root == p || root == q {
		isCurrentNeeded = true
	}
	nodeInLeftSubTree := isNodeFound(root.Left, p, q, ans)
	nodeInRightSubTree := isNodeFound(root.Right, p, q, ans)
	if isCurrentNeeded {
		if nodeInLeftSubTree || nodeInRightSubTree {
			ans.Val = root.Val
			return true
		}
	} else if nodeInLeftSubTree && nodeInRightSubTree {
		ans.Val = root.Val
		return true
	}
	return nodeInLeftSubTree || nodeInRightSubTree || isCurrentNeeded
}
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	var ans TreeNode
	isNodeFound(root, p, q, &ans)
	return &ans
}