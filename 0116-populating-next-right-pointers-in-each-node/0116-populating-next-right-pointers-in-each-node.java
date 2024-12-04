/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public void addNext(Node left, Node right, Node rightNext){
        if(left == null){
            return;
        }
        left.next = right;
        right.next = rightNext;
        addNext(left.left, left.right, right.left);
        rightNext = rightNext == null? rightNext: rightNext.left;
        addNext(right.left, right.right, rightNext);
    }
    public Node connect(Node root) {
        if(root == null || root.right == null){
            return root;
        }
        addNext(root.left, root.right, null);
        return root;
    }
}