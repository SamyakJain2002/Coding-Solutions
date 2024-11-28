class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 =word2.length();
        int[] dp = new int[l2+1];
        int[] prev = new int[l2+1];
        for(int i=0;i<=l2;i++){
            prev[i] = i;
        }

        for(int i=1;i<=l1;i++){
            dp[0] = i;
            for(int j=1;j<=l2;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[j] = prev[j-1];
                }else{
                    dp[j] = 1 + Math.min(prev[j], Math.min(prev[j-1],dp[j-1]));
                }
            }
            prev = (int[])(dp.clone());
        }
        return prev[l2];
    }
}