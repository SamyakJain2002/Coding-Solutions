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
        if(node == null){
            return null;
        }
        Map<Node, Node> mp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        boolean[] vis = new boolean[101];
        q.add(node);
        while(!q.isEmpty()){
            Node top = q.poll();
            if(vis[top.val]){
                continue;
            }
            Node cp = new Node(top.val);
            mp.put(top, cp);
            for(Node i: top.neighbors){
                if(!vis[i.val]){
                    q.add(i);
                }
            }
            vis[top.val] = true;
        }
        
        Arrays.fill(vis, false);
        q.add(node);
        while(!q.isEmpty()){
            Node top = q.poll();
            if(vis[top.val]){
                continue;
            }
            Node cp = mp.get(top);
            for(Node i: top.neighbors){
                if(!vis[i.val]){
                    q.add(i);
                }
                cp.neighbors.add(mp.get(i));
            }
            vis[top.val] = true;
        }
        return mp.get(node);
    }
}