// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution{
public:
    int minThrow(int N, int arr[]){
        vector<vector<int>> adj(30);
        for(int i=0;i<30;i++){
            for(int j=i+1;j<i+7 && j<30;j++){
                adj[i].push_back(j);
            }
        }
        for(int i =0;i<N;i++){
            for(int j = arr[2*i]-2;j > (arr[2*i]-8) && j>=0;j--){
                adj[j].push_back(arr[2*i+1]-1);
                //cout<< j<<" "<< arr[2*i+1]-1<<endl;
            }
                
        }
        
        queue<pair<int,int>> q;
        vector<bool> vis(30,false);
        q.push({0,0});
        while(!q.empty()){
            auto temp = q.front();
            int t = temp.first;
            int dis = temp.second;
            q.pop();
            if(t == 29){
            return dis;
            }
            vis[t] = true;
            for(auto i: adj[t]){
                if(!vis[i]){
                    q.push({i,dis+1});
                }
            }
        }
    }
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int N;
        cin>>N;
        int arr[2*N];
        for(int i = 0;i < 2*N;i++)
            cin>>arr[i];
        
        Solution ob;
        cout<<ob.minThrow(N, arr)<<"\n";
    }
    return 0;
}  // } Driver Code Ends