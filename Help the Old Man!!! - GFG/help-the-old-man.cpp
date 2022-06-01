// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution{
public:
    void tower(int s,int d,int m, int N,int &n, vector<int> &ans){
        
        if(N==0)
        return;
        
        
        tower(s, m, d, N-1,n,ans);
        --n;
       
        if(n==0){
            ans.push_back(s);
            ans.push_back(d);
            return;
        }
        tower(m, d, s,N-1,n,ans);
    }
    vector<int> shiftPile(int N, int n){
        vector<int> ans;
        
        tower(1, 3, 2, N, n, ans);
        return ans;
    }
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int N, n;
        cin>>N>>n;
        
        Solution ob;
        vector<int> ans = ob.shiftPile(N, n);
        cout<<ans[0]<<" "<<ans[1]<<endl;
    }
    return 0;
}  // } Driver Code Ends