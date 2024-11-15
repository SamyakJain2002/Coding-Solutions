class Solution {
    public int uniquePaths(int m, int n) {
        int []dp = new int[n];
        Arrays.fill(dp,1);
        int [] curr = new int[n];
        Arrays.fill(curr, 1);
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
            curr[j] = dp[j] + curr[j-1];
        }
            dp = curr;
        }
        
        return curr[n-1];
    }
}