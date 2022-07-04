// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
  public:
    void bfs(int i, int j, int n, int m,vector<vector<char>>& grid){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]=='0') return;
        grid[i][j]='0';

            bfs(i+1,j,n,m,grid);
            bfs(i+1,j+1,n,m,grid);
            bfs(i,j+1,n,m,grid);
            bfs(i-1,j+1,n,m,grid);
            bfs(i-1,j,n,m,grid);
            bfs(i-1,j-1,n,m,grid);
            bfs(i,j-1,n,m,grid);
            bfs(i+1,j-1,n,m,grid);
    }
  
    // Function to find the number of islands.
    int numIslands(vector<vector<char>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        int ans =0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    bfs(i,j,n,m,grid);
                   // cout<<i<<" "<<j<<endl;
                    ans++;
                }
            }
        }
        return ans;
    }
};

// { Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n, m;
        cin >> n >> m;
        vector<vector<char>> grid(n, vector<char>(m, '#'));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> grid[i][j];
            }
        }
        Solution obj;
        int ans = obj.numIslands(grid);
        cout << ans << '\n';
    }
    return 0;
}  // } Driver Code Ends