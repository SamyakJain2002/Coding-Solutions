/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func hasCycle(head *ListNode) bool {
    // if(head.Next == nil){
    //     return false
    // }
        
    slow, fast := head, head
    for(fast!=nil && fast.Next!=nil){
        fast = fast.Next.Next
        slow = slow.Next
        if(fast == slow){
            return true;
        }
    }
    return false
}