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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode((l1.val + l2.val)%10, null);
        ListNode temp = newHead;
        int carry = (l1.val + l2.val)/10;
        l1 = l1.next;
        l2 = l2.next;
        while(l1!=null && l2!=null){
            temp.next = new ListNode((l1.val + l2.val+carry)%10, null);
            carry = (l1.val + l2.val+carry)/10;
            l1 = l1.next;
            l2 = l2.next;
            temp = temp.next;
        }
        while(l1!=null){
            temp.next = new ListNode((l1.val + carry)%10, null);
            carry = (l1.val + carry)/10;
            l1 = l1.next;
            temp = temp.next;
        }
        while(l2!=null){
            temp.next = new ListNode((l2.val+carry)%10, null);
            carry = (l2.val + carry)/10;
            l2 = l2.next;
            temp = temp.next;
        }
        if(carry > 0){
            temp.next = new ListNode((carry)%10, null);
        }
        return newHead;
    }
}