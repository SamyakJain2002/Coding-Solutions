class Solution {
    public int minPathSum(int[][] grid) {
        int[]prev = new int[grid[0].length];
        int n = grid[0].length;
        int m = grid.length;
        Arrays.fill(prev, Integer.MAX_VALUE);
        for(int i=0;i<m;i++){
            prev[0] = (i!=0)? prev[0] + grid[i][0]: grid[i][0];
            for(int j=1;j<n;j++){
                prev[j] = Math.min(prev[j], prev[j-1]);
                prev[j] += grid[i][j];
            }
        }
        return prev[n-1];
    }
}