class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        int n = s.length();
        dp[n] = true;
        for(int i=n-1;i>=0;i--){
            for(int j = i;j<=n;j++){
                if(dp[j] && wordDict.contains(s.substring(i,j))){
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }
}