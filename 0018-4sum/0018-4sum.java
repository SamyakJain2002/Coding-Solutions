class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> sol = new ArrayList<>();
        for(int i=0;i<nums.length-3;i++){
            if(i!=0 && nums[i] == nums[i-1])
                continue;
            for(int j=i+1;j<nums.length-2;j++){
                if(j!=i+1 && nums[j] == nums[j-1])
                    continue;
                int k = j+1, l = nums.length-1;
                while(k<l){
                    if(target == (long)nums[i]+nums[j]+nums[k]+nums[l]){
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                        sol.add(temp);
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]) k++;
                        while(k<l && nums[l]== nums[l+1]) l--;
                    } else if(target > nums[i]+nums[j]+nums[k]+nums[l]){
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }
        return sol;
    }
}