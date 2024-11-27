/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 type Pair struct{
    First int
    Second *TreeNode
 }
func zigzagLevelOrder(root *TreeNode) [][]int {
    if(root == nil){
        return nil
    }
    var queue []*TreeNode
    var ans [][]int
    queue = append(queue,root)
    appendLeft := true
    for(len(queue)!=0){
        n := len(queue)
        row := make([]int, n)
        for i := range n {
            root = queue[i]
            idx := i
            if(!appendLeft){
                idx = n-i-1
            }
            row[idx] = root.Val
            if(root.Left != nil){
                queue = append(queue,root.Left)
            }
            if(root.Right != nil){
                queue = append(queue, root.Right)
            }
            
        }
        appendLeft = !appendLeft
        queue = queue[n:]
        ans = append(ans, row)
    }
    return ans
}