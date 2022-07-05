// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends


class Solution
{
	public:
	//Function to find number of strongly connected components in the graph.
	void dfs(vector<bool>& vis, int i, stack<int>& s, const vector<int> adj[]){

	    vis[i] = true;
	    for(auto j: adj[i]){
	        if(!vis[j]){
	           dfs(vis,j,s,adj); 
	        }
	    }
	    s.push(i);
	}
	
	void dfsUtil(const vector<int> adj[], vector<bool>& vis, int src){
	    vis[src] = true;
	    for(auto i: adj[src]){
	        if(!vis[i]){
	           dfsUtil(adj,vis,i); 
	        }
	    }
	}
	
    int kosaraju(int V, vector<int> adj[])
    {
        stack<int> s;
        vector<bool> vis(V,false);
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(vis, i, s, adj);
            }
        }
        vector<int> trans[V];
        for(int i=0;i<V;i++){
            vis[i] = false;
            for(auto j : adj[i]){
                trans[j].push_back(i);
            }
        }
        
        int ans = 0;
        while(!s.empty()){
            int src = s.top();
            s.pop();
            if(!vis[src]){
            dfsUtil(trans, vis, src);
            ans++;
            }
        }
        return ans;
    }
};

// { Driver Code Starts.


int main()
{
    
    int t;
    cin >> t;
    while(t--)
    {
    	int V, E;
    	cin >> V >> E;

    	vector<int> adj[V];

    	for(int i = 0; i < E; i++)
    	{
    		int u, v;
    		cin >> u >> v;
    		adj[u].push_back(v);
    	}

    	Solution obj;
    	cout << obj.kosaraju(V, adj) << "\n";
    }

    return 0;
}

  // } Driver Code Ends