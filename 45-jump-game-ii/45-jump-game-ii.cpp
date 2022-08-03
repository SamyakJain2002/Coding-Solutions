class Solution {
public:
   int solve(vector<int>& dp, vector<int>& nums, int i, int n){
        if(i >= n-1){
            return dp[n-1] = 0;
        }
        if(dp[i]!=INT_MAX){
            return dp[i];
        }
        int mi = INT_MAX;
        if(nums[i]==0){
            return INT_MAX;
        }
        for(int j=1;j<=nums[i];j++){
            mi = min(mi,solve(dp,nums,i+j,n));
        }
       if(mi!=INT_MAX)
        return dp[i] = mi+1;
       return dp[i];
    }
    
   int jump(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n+1,INT_MAX);
        solve(dp,nums,0,n);
        return dp[0];
    }
};