class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int lcs = 1;
        for(int i: set){
            if(set.contains(i-1)){
                continue;
            }
            int x = i;
            int cnt =1;
            while(set.contains(x+1)){
                cnt++;
                x = x+1;
            }
            lcs = Math.max(cnt, lcs);
        }
        return lcs;
    }
}