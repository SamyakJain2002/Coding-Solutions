class Solution {
    static void recur(int []nums, int n, int idx, List<Integer> select, Set<List<Integer>> sol){
        if(idx == n){
            sol.add(new ArrayList<>(select));
            return;
        }
        recur(nums, n, idx+1, select, sol);
        select.add(nums[idx]);
        recur(nums, n, idx+1, select, sol);
        select.remove(select.size()-1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> sol = new HashSet<>();
        List<Integer> select = new ArrayList<>();
        Arrays.sort(nums);
        recur(nums, nums.length, 0, select, sol);
        List<List<Integer>> ans = new ArrayList<>();

        for(List<Integer> i : sol){
            ans.add(i);
        }
        return ans;
    }
}