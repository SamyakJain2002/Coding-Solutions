/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node temp = head;
        while(temp != null){
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }
        Node head2 = head.next;
        temp = head;
        while(temp!=null){
            if(temp.random !=null){
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        temp = head;
        Node temp2 = new Node(-1);
        while(temp!=null){
            temp2.next = temp.next;
            temp.next = temp.next.next;
            temp = temp.next;
            temp2 = temp2.next;
        }
        return head2;
    }
}