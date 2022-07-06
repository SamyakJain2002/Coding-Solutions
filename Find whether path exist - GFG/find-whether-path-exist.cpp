// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends

class Solution
{
    public:
    //Function to find whether a path exists from the source to destination.
    bool is_Possible(vector<vector<int>>& grid) 
    {
        int n = grid.size();
        int fx=0;int fy=0;
        int x =0;int y =0;
        for(int i = 0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    x = i;y=j;
                }
                if(grid[i][j]==2){
                    fx = i;fy = j;
                }
            }
        }
        queue<pair<int,int>> q;
        q.push({x,y});
        grid[x][y] = 0;
        while(!q.empty()){
            x = q.front().first;
            y = q.front().second;
            q.pop();
            if(x == fx && y==fy){
                return true;
            }
            if(x>0 && grid[x-1][y]!=0){
                q.push({x-1,y});
                grid[x-1][y]=0;
            }
            if(y>0 && grid[x][y-1]!=0){
                q.push({x,y-1});
                grid[x][y-1]=0;
            }
            if(y<n-1 && grid[x][y+1]!=0){
                q.push({x,y+1});
                grid[x][y+1]=0;
            }
            if(x<n-1 && grid[x+1][y]!=0){
                q.push({x+1,y});
                grid[x+1][y]=0;
            }
        }
        return false;
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
		bool ans = obj.is_Possible(grid);
		cout << ((ans) ? "1\n" : "0\n");
	}
	return 0;
}  // } Driver Code Ends