/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Map<Integer, Map<Integer, Integer>>> mp = new TreeMap<>();
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> q = new LinkedList<>();
        q.add(new Pair(root, new Pair(0, 0)));

        while (!q.isEmpty()) {
            Pair<TreeNode, Pair<Integer, Integer>> currroot = q.poll();
            root = currroot.getKey();
            int hd = currroot.getValue().getKey();
            int level = currroot.getValue().getValue();
            mp.computeIfAbsent(hd, k -> new TreeMap<>()).computeIfAbsent(level, k -> new TreeMap<>()).merge(root.val, 1,
                    Integer::sum);
            if (root.left != null) {
                q.add(new Pair(root.left, new Pair(hd - 1, level + 1)));
            }
            if (root.right != null) {
                q.add(new Pair(root.right, new Pair(hd + 1, level + 1)));
            }
        }

        for (Map.Entry<Integer, Map<Integer, Map<Integer, Integer>>> outerEntry : mp.entrySet()) {
            Map<Integer, Map<Integer, Integer>> innerMap = outerEntry.getValue();
            List<Integer> a1 = new ArrayList<>();
            for (Map.Entry<Integer, Map<Integer, Integer>> innerEntry : innerMap.entrySet()) {
                Map<Integer, Integer> value = innerEntry.getValue();
                for(Map.Entry<Integer,Integer> finalMap : value.entrySet()){
                    int v = finalMap.getValue();
                    int k = finalMap.getKey();
                    for(int i=1;i<=v;i++){
                        a1.add(k);
                    }
                }
            }
            ans.add(a1);
        }
        return ans;
    }
}