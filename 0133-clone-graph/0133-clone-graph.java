/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> mp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        mp.put(node, new Node(node.val));
        while (!q.isEmpty()) {
            Node top = q.poll();
            Node cp = mp.get(top);
            for (Node i : top.neighbors) {
                if (mp.containsKey(i)) {
                    cp.neighbors.add(mp.get(i));
                } else {
                    mp.put(i, new Node(i.val));
                    q.add(i);
                    cp.neighbors.add(mp.get(i));
                }
            }
        }
        return mp.get(node);
    }
}