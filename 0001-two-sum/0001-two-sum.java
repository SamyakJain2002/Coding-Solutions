class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] copy = nums.clone();
        Arrays.sort(nums);
        int i=0, j = nums.length-1;
        int[] ans = new int[2];
        while(i<j){
            if(target - nums[i] > nums[j]){
                i++;
            } else if(target - nums[i] < nums[j]){
                j--;
            } else {
                ans[0] = i;
                ans[1] = j;
               break;
            }
        }
        int a1 = nums[ans[0]]; boolean a1found = false;
        int a2 = nums[ans[1]]; boolean a2found = false;
        for(i=0;i<nums.length;i++){
            if(!a1found && a1 == copy[i]){
                ans[0] = i;
                a1found = true;
            }else if(!a2found && a2 == copy[i]){
                ans[1] = i;
                a2found = true;
            }
        }
        return ans;
    }
}