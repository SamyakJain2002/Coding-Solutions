// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function Template for C++

class Solution {
public:
    int findpath(vector<vector<int>>& matrix,int xs, int ys, int xd, int yd, vector<vector<int>>vis, int m, int n){
    if(xs == xd && ys == yd){
    return 0;
    }
    else{
        int ans1 =0, ans2 = 0, ans3 = 0,ans4=0;
        vis[xs][ys]=1;
            if(ys<m-1 && vis[xs][ys+1]==0 && matrix[xs][ys+1]!=0){
                ans1 = 1 + findpath(matrix, xs, ys+1, xd, yd,vis, m, n);
            }
            if(ys>0 && vis[xs][ys-1]==0 && matrix[xs][ys-1]!=0){
                ans2 = 1+findpath(matrix, xs, ys-1, xd, yd,vis, m, n);
            }
            if(xs<n-1 && vis[xs+1][ys]==0 && matrix[xs+1][ys]!=0){
                ans3 = 1+findpath(matrix, xs+1, ys, xd, yd,vis, m, n);
            }
            if(xs>0 && vis[xs-1][ys]==0 && matrix[xs-1][ys]!=0){
                ans4 = 1+findpath(matrix, xs-1, ys, xd, yd,vis, m, n);
            }
            if(ans1 || ans2 || ans3||ans4){
                return max(max(ans1,ans2),max(ans3,ans4));
                
            }
           
            return -1;
            
        }
    }
    
    int longestPath(vector<vector<int>> matrix, int xs, int ys, int xd, int yd)
    {
       if(matrix[xs][ys]==0||matrix[xd][yd]==0)
       return -1;
        int n = matrix.size();
        int m = matrix[0].size();
         vector<vector<int>> vis(n,vector<int>(m,0));
         
        int ans = findpath(matrix,xs,ys,xd,yd,vis, m, n);
        return ans;
    }
};

// { Driver Code Starts.

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n, m;
        cin >> n >> m;
        int xs, ys, xd, yd;
        cin >> xs >> ys >> xd >> yd;
        vector<vector<int>> mat(n, vector<int>(m));
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                cin >> mat[i][j];
            }
        }
        Solution ob;
        int ans = ob.longestPath(mat, xs, ys, xd, yd);
        cout << ans;
        cout << "\n";
    }
    return 0;
}  // } Driver Code Ends