/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0, l2 = 0;
        ListNode temp1 = headA; ListNode temp2 = headB;
        while(temp1!=null){
            l1++;
            temp1 = temp1.next;
        }
        while(temp2!=null){
            l2++;
            temp2 = temp2.next;
        }
        temp1 = headA;
        temp2 = headB;
        while(l1>l2){
            temp1 = temp1.next;
            l1--;
        }
        while(l2>l1){
            temp2 = temp2.next;
            l2--;
        }
        while(temp1!=null && temp2!=null){
            if(temp1 == temp2){
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }
}