class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low =0, high = nums.length-1;
        if(nums.length ==1){
            return nums[0];
        }
        if(nums[0] != nums[1]){
            return nums[0];
        }
        if (nums[high] != nums[high-1]){
            return nums[high];
        }
        low = 1;
        high--;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] != nums[mid+1] && nums[mid]!= nums[mid-1]){
                return nums[mid];
            }
            if((nums[mid] == nums[mid+1] && mid%2 == 0)||(nums[mid] == nums[mid-1] && mid%2 ==1)){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return -1;
    }
}