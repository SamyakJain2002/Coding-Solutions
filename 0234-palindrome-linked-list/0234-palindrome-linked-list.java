/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode curr = head, prev = null;
        while(fast!=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            curr.next = prev;
            prev = curr;
            curr = slow;
        }
        if(fast != null){
            slow = slow.next;
        }
        while(slow!=null){
            if(slow.val != prev.val){
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }
}