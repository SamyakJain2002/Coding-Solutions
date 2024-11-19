class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0, j=1, k=1;
        while(j<=nums.length-1){
            if(nums[j]!=nums[j-1]){
                i++;
                k++;
                nums[i] = nums[j];
            }
            j++;
        }
        return k;
    }
}