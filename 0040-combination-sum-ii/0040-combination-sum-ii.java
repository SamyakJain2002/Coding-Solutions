class Solution {
    static void recur(int[] candidates, int target, int idx, List<Integer> curr, List<List<Integer>> sol){
        if(target ==0){
            sol.add(new ArrayList<>(curr));
            return;
        }
        if(idx == candidates.length){
            return;
        }
        if(target < candidates[idx]){
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i!=idx && candidates[i]==candidates[i-1]){
                continue;
            }
            curr.add(candidates[i]);
            recur(candidates, target-candidates[i], i+1, curr, sol);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        recur(candidates, target, 0, curr, sol);
        return sol;
    }
}