// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int shortestDistance(int N, int M, vector<vector<int>> A, int X, int Y) {
        if(A[0][0]==0 || A[X][Y] == 0){
            return -1;
        }
        queue<pair<int,pair<int,int>>> q;
        q.push({0,{0,0}});
        A[0][0] =0;
        
        
        while(!q.empty()){
            int curdis = q.front().first;
            int x = q.front().second.first;
            int y = q.front().second.second;
            //cout<<x<<" "<<y<<endl;
            q.pop();
            
            if(x==X && y== Y){
                return curdis;
            }
            
            if(x>0 && A[x-1][y]==1){
                q.push({curdis+1,{x-1,y}});
                A[x-1][y] = 0;
            }
            if(y>0 && A[x][y-1]){
                q.push({curdis+1,{x,y-1}});
                A[x][y-1] =0;
            }
            if(y<M-1 && A[x][y+1]==1){
                q.push({curdis+1,{x,y+1}});
                A[x][y+1] = 0;
            }
            if(x<N-1 && A[x+1][y]==1){
                q.push({curdis+1,{x+1,y}});
                A[x+1][y] = 0;
            }
        }
        return -1;
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N, M, x, y;
        cin >> N >> M;
        vector<vector<int>> v(N, vector<int>(M));
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) cin >> v[i][j];
        cin >> x >> y;
        Solution ob;
        cout << ob.shortestDistance(N, M, v, x, y) << "\n";
    }
}  // } Driver Code Ends