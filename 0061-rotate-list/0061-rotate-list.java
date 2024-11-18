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
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while(temp !=null){
            len++;
            temp = temp.next;
        }
        if(len == 0 || k ==0 || k%len == 0){
            return head;
        }
        k = k % len;
        int t = len -1-k;
        temp = head;
        while(t>0){
            temp = temp.next;
            t--;
        }
        ListNode t1 = temp.next;
        temp.next = null;
        temp = t1;
        t1 = head;
        head = temp;
        while(temp.next != null){
            temp = temp.next;
        }    
        temp.next = t1;
        return head;
    }
}