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
        HashMap<Node,List<Node>> mp = new HashMap<Node, List<Node>>();
        Node temp = head;
        Node head2 = new Node(head.val);
        Node temp2 = head2;
        if(temp.random != null)
        mp.put(temp.random, new ArrayList<Node>(Arrays.asList(temp2)));
        while(temp.next != null){
            temp = temp.next;
            temp2.next = new Node(temp.val);
            temp2 = temp2.next;
            if(mp.containsKey(temp)){
                List<Node> arr = mp.get(temp);
                for(Node i: arr){
                    i.random = temp2;
                }
                mp.remove(temp);
            }
            if(temp.random != null){
                if(mp.containsKey(temp.random)){
                    mp.get(temp.random).add(temp2);
                }else{
                    mp.put(temp.random, new ArrayList<Node>(Arrays.asList(temp2)));
                }
                
            }
           
        }
        temp = head;
        temp2 = head2;
        while(temp!=null){
            if(mp.containsKey(temp)){
                List<Node> arr = mp.get(temp);
                for(Node i: arr){
                    i.random = temp2;
                }
                mp.remove(temp);
            }
            temp = temp.next;
            temp2 = temp2.next;
        }
        return head2;
    }
}