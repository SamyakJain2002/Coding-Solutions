// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
public:
    bool bfs(int src, int V, vector<int> & col, vector<int>adj[]){
        col[src] = 1;
        queue<int> q;
        q.push(src);
        
        while(!q.empty()){
            int v = q.front();
            q.pop();
            int curcol = col[v];
            for(auto& i: adj[v]){
                if(col[i] == -1){
                    col[i] = 1-curcol;
                    q.push(i);
                }
                else if(col[i] == curcol){
                    return false;
                }
            }
        }
        return true;
    }

	bool isBipartite(int V, vector<int>adj[]){
	    vector<int> col(V,-1);
	   
	    for(int i=0;i<V;i++){
	        if(col[i] == -1){
	            if(!bfs(i,V,col,adj))
	            return false;
	        }
	    }
	    return true;
	}

};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int V, E;
		cin >> V >> E;
		vector<int>adj[V];
		for(int i = 0; i < E; i++){
			int u, v;
			cin >> u >> v;
			adj[u].push_back(v);
			adj[v].push_back(u);
		}
		Solution obj;
		bool ans = obj.isBipartite(V, adj);    
		if(ans)cout << "1\n";
		else cout << "0\n";  
	}
	return 0;
}  // } Driver Code Ends