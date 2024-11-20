class Solution {
    static void recur(int []nums, List<List<Integer>> ans, List<Integer> selected){
        if (selected.size() >= nums.length){
            ans.add(new ArrayList<>(selected));
            return;
        }
        for(int i: nums){
            if(selected.contains(i)){
                continue;
            }
            selected.add(i);
            recur(nums, ans, selected);
            selected.remove(selected.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> selected = new ArrayList<>();
        recur(nums, ans, selected);
        return ans;
    }
}