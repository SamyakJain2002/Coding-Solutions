// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution
{
    public:
    void dfs(int src, vector<bool>& vis, const vector<int> adj[]){
        vis[src] = true;
        for(auto i: adj[src]){
            if(!vis[i]){
                dfs(i,vis,adj);
            }
        }
    }
    
    int isCircle(int N, vector<string> A)
    {
        vector<int> adj[26];
        vector<int> indegree(26,0);
        vector<int> outdegree(26,0);
        
        for(auto i: A){
            adj[i[0]-'a'].push_back(i.back()-'a');
            indegree[i.back()-'a']++;
            outdegree[i[0]-'a']++;
        }
        
        for(int i=0;i<26;i++){
            if(indegree[i]!=outdegree[i]){
                return 0;
            }
        }
        
        vector<bool> vis(26,false);
        int i1=0;
        for(;i1<26;i1++){
            if(outdegree[i1]>0){
                break;
            }
        }
        dfs(i1, vis, adj);
        for(int i=0;i<26;i++){
            if(!vis[i] && outdegree[i]>0){
                return 0;
            }
        }
        
        return 1;
    }
};

// { Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t--){
        int N;
        cin>>N;
        vector<string> A;
        string s;
        
        for(int i = 0;i < N; i++)
        {
            cin>>s;
            A.push_back(s);
        }
        
        Solution ob;
        cout<<ob.isCircle(N, A)<<endl;
    }
    return 0;
}  // } Driver Code Ends