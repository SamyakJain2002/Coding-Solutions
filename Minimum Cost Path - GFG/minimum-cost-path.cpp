// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends


class Solution
{
    public:
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    int minimumCostPath(vector<vector<int>>& grid) 
    {
        int n = grid.size();
        priority_queue<pair<int,pair<int,int>>, vector<pair<int,pair<int,int>>>, greater<pair<int,pair<int,int>>>> pq;
        pq.push({grid[0][0],{0,0}});
        vector<vector<int>> dis(n,vector<int> (n,INT_MAX));
        vector<vector<bool>> vis(n,vector<bool> (n,false));
        dis[0][0] = 9;
        
        while(!pq.empty()){
            auto temp = pq.top();
            int x = temp.second.first;
            int y = temp.second.second;
            int curdis = temp.first;
            //cout<<x<<" "<<y<<" "<<curdis<<endl;
            pq.pop();
            if(x==n-1 && y==n-1){
                return curdis;
            }
            if(vis[x][y]){
                continue;
            }
            vis[x][y] = true;
            if(x>0 && dis[x-1][y]> curdis+grid[x-1][y]){
                dis[x-1][y] = curdis+grid[x-1][y];
                pq.push({dis[x-1][y],{x-1,y}});
            }
            if(y>0 && dis[x][y-1]> curdis+grid[x][y-1]){
                dis[x][y-1] = curdis+grid[x][y-1];
                pq.push({dis[x][y-1],{x,y-1}});
            }
            if(x<n-1 && dis[x+1][y]> curdis+grid[x+1][y]){
                dis[x+1][y] = curdis+grid[x+1][y];
                pq.push({dis[x+1][y],{x+1,y}});
            }
            if(y<n-1 && dis[x][y+1]> curdis+grid[x][y+1]){
                dis[x][y+1] = curdis+grid[x][y+1];
                pq.push({dis[x][y+1],{x,y+1}});
                //cout<<x<<" "<<y<<" "<<dis[x][y+1]<<endl;
            }
        }
        return dis[n-1][n-1]; 
    }
};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<vector<int>>grid(n, vector<int>(n, -1));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				cin >> grid[i][j];
			}
		}
		Solution obj;
		int ans = obj.minimumCostPath(grid);
		cout << ans << "\n";
	}
	return 0;
}  // } Driver Code Ends