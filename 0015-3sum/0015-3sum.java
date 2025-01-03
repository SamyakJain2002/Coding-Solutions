class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sol = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            int j = i+1, k = nums.length-1;
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            while(j<k){
                if(nums[j]+nums[k]+nums[i] == 0){
                    sol.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(k>j && nums[k]==nums[k+1]) k--;
                } else if(nums[j]+nums[k]+nums[i] > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return sol;
    }
}