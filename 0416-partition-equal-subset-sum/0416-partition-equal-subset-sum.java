class Solution {
    public boolean canPartition(int[] arr) {
        int k = 0;
        for(int i: arr){
            k += i;
        }
        if(k%2 != 0){
            return false;
        }
        k = k/2;
        int n =arr.length;
     boolean prev[] = new boolean[k + 1];
        
        // Initialize the first row of the DP table
        prev[0] = true;

        // Initialize the first column of the DP table
        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }

        // Fill in the DP table using bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            // Create an array to store the current row of the DP table
            boolean cur[] = new boolean[k + 1];
            
            // Initialize the first column of the current row
            cur[0] = true;
            
            for (int target = 1; target <= k; target++) {
                // Calculate if the current target can be achieved without taking the current element
                boolean notTaken = prev[target];
                
                // Calculate if the current target can be achieved by taking the current element
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = prev[target - arr[ind]];
                }
                
                // Store the result in the current row of the DP table
                cur[target] = notTaken || taken;
            }
            
            // Update the previous row with the current row
            prev = cur;
        }

        // The final result is stored in the last cell of the previous row
        return prev[k];   
    }
}