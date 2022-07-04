// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
  public:
    // Function to detect cycle in an undirected graph.
    bool isCycle(int V, vector<int> adj[]) {
        vector<int>vis(V,-1);
        queue<int> q;
        for(int i=0;i<V;i++){
            if(vis[i]==-1){
                q.push(i);
                vis[i] = 0;
                while(!q.empty()){
                    int temp = q.front();
                    int cd = vis[temp];
                    q.pop();
                    for(auto j: adj[temp]){
                        if(vis[j]!= -1){
                            if(vis[j]>=cd){
                                return true;
                            }
                        }
                        else{
                            vis[j] = cd+1;
                            q.push(j);
                        }
                    }
                }
            }
        }
        return false;
    }
};

// { Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int V, E;
        cin >> V >> E;
        vector<int> adj[V];
        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        Solution obj;
        bool ans = obj.isCycle(V, adj);
        if (ans)
            cout << "1\n";
        else
            cout << "0\n";
    }
    return 0;
}  // } Driver Code Ends