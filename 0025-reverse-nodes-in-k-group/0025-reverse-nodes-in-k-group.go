/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

 func recur(head *ListNode, k, len int) *ListNode{
    if(head == nil || head.Next == nil || len < k){
        return head
    }
    t := k
    temp := head
    curr, next := head, head
    var prev *ListNode
    for(curr != nil && t>0){
        next = next.Next
        curr.Next = prev
        prev = curr
        curr = next
        t--
    }
    temp.Next = recur(curr, k, len-k)
    return prev
 }

func reverseKGroup(head *ListNode, k int) *ListNode {
    temp := head
    len := 0
    for(temp!=nil){
        len++
        temp = temp.Next
    }
    return recur(head, k, len)
}