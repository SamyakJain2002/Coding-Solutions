class Solution {
    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    private void recur(int []nums, List<List<Integer>> ans, int idx){
        if (idx == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i: nums){
                ds.add(i);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=idx;i<nums.length; i++){
            swap(i,idx, nums);
            recur(nums, ans, idx+1);
            swap(i,idx, nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recur(nums, ans, 0);
        return ans;
    }
}