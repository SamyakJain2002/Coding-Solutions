class Solution {
    static void recur(int[] nums, int idx, int n, List<List<Integer>> ans, List<Integer> curr){
        ans.add(new ArrayList<>(curr));

        for(int i=idx;i<n;i++){
            if(i!=idx && nums[i]==nums[i-1]){
                continue;
            } 
            curr.add(nums[i]);
            recur(nums, i+1, n, ans, curr);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        recur(nums, 0, nums.length, ans, curr);
        return ans;
    }
}