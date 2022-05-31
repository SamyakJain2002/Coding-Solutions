// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution 
{
    public:
    //Function to find minimum time required to rot all oranges. 
    int orangesRotting(vector<vector<int>>& grid) {
        queue<pair<int,int>> q;
        int n = grid.size();
        int m = grid[0].size();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.push({i,j});
                }
            }
        }
        if(q.empty())
        return -1;
        q.push({-1,-1});
        int count = 0;
        while(!q.empty()){
            int a = q.front().first;
            int b = q.front().second;
            q.pop();
            if(a == -1 && b== -1 ){
                if(!q.empty()){
                count++;
                q.push({-1,-1});
                }
            }
            else{
            if(a>0 && grid[a-1][b]== 1)
            {
            grid[a-1][b]=2;
            q.push({a-1,b});
            }
            
            if(a<n-1 && grid[a+1][b]== 1 )
            {
            grid[a+1][b]=2;
            q.push({a+1,b});
            }
            
            if(b>0 && grid[a][b-1]== 1)
            {
            grid[a][b-1]=2;
            q.push({a,b-1});
            }
            
            if(b<m-1 && grid[a][b+1]== 1)
            {
            grid[a][b+1]=2;
            q.push({a,b+1});
            }
            
            }
        }
        
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return count;
    }
};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n, m;
		cin >> n >> m;
		vector<vector<int>>grid(n, vector<int>(m, -1));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				cin >> grid[i][j];
			}
		}
		Solution obj;
		int ans = obj.orangesRotting(grid);
		cout << ans << "\n";
	}
	return 0;
}  // } Driver Code Ends