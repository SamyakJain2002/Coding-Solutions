class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> sub = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(sub.size() == 0 || nums[i] > sub.get(sub.size()-1)){
                sub.add(nums[i]);
            }else{
                int low = Collections.binarySearch(sub, nums[i]);
                if(low<0){
                    low = -(low+1);
                }
                sub.set(low, nums[i]);
            }
        }
        return sub.size();
    }
}