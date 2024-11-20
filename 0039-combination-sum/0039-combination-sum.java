class Solution {
    static void addElement(List<Integer> curr, int n, int element){
        while(n>0){
            curr.add(element);
            n--;
        }
    }

    static void removeElement(List<Integer> curr, int n){
        while(n>0){
            curr.remove(curr.size()-1);
            n--;
        }
    }

    static void recur(int []candidates, int target, List<List<Integer>> ans, List<Integer> curr, int idx){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
        }
        if(idx == candidates.length){
            return;
        }
        if(target < candidates[idx]){
            return;
        }

        int n = target/candidates[idx];
        while(n>=0){
            addElement(curr, n, candidates[idx]);
            recur(candidates, target-candidates[idx]*n, ans, curr, idx+1);
            removeElement(curr, n);
            n--;
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        recur(candidates, target, ans, curr, 0);
        return ans;
    }
}