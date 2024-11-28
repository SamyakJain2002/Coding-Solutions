class Solution {
    int getAns(int[] nums, int n, int curr, int prev, int[][] dp) {
        if (curr == n) {
            return 0;
        }
        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev + 1];
        }
        int take = 0;
        int notTake = getAns(nums, n, curr + 1, prev, dp);
        if (prev == -1 || nums[curr] > nums[prev]) {
            take = getAns(nums, n, curr + 1, curr, dp) + 1;
        }
        dp[curr][prev + 1] = Math.max(take, notTake);
        return dp[curr][prev + 1];
    }
    // public int lengthOfLIS(int[] nums) {
    // int n = nums.length;
    // int[][] dp = new int[n][n+1];
    // for(int row[]:dp){
    // Arrays.fill(row, -1);
    // }
    // return getAns(nums, n, 0, -1, dp);
    // }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int idx = 0; idx < n; idx++) {
            for (int prev = 0; prev < idx; prev++) {
                if (nums[idx] > nums[prev]) {
                    dp[idx] = Math.max(dp[prev] + 1, dp[idx]);
                }
            }
        }

        int max = 0;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        return max;
    }
}