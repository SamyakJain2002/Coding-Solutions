class Solution {
    public int getAns(int []coins, int amount, int idx){
        if(amount == 0){
            return 0;
        }
        if(idx == coins.length || amount < coins[idx]){
            return -1;
        }
        int include = getAns(coins, amount - coins[idx], idx);
        int notInclude = getAns(coins, amount, idx+1);
        if(include == -1){
            return notInclude;
        }else if(notInclude == -1){
            return include+1;
        }
        return Math.min(include+1, notInclude);
    }
    public int coinChange(int[] coins, int amount) {
        int [][] dp = new int[coins.length+1][amount+1];
        for(int i[]: dp){
            Arrays.fill(i, -1);
        }
        for(int i=0;i<=amount;i++){
            if(i%coins[0] == 0){
                dp[0][i] = i/coins[0];
            }
        }
        for(int i=1;i<coins.length;i++){
            for(int j = 0;j<=amount;j++){
                if(j < coins[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    int take = dp[i][j-coins[i]];
                    int notTake = dp[i-1][j];
                    if(take == -1){
                        dp[i][j] = notTake;
                    }else if(notTake == -1){
                        dp[i][j] = take+1;
                    }else{
                        dp[i][j] = Math.min(take+1, notTake);
                    }
                    
                }
            }
        }
        return dp[coins.length-1][amount];
    }
}