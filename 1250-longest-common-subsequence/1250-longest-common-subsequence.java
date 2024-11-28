class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int[] dp = new int[n2 + 1];
        int[] prev = new int[n2+1];
        Arrays.fill(dp, 0);
        Arrays.fill(prev,0);
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = prev[j - 1] + 1;
                } else {
                    dp[j] = Math.max(dp[j-1], prev[j]);
                }
            }
            prev = (int[])(dp.clone());
        }
        return prev[n2];
    }
}