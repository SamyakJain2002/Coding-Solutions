// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function template for C++

class Solution
{
  public:
    //Function to find maximum of each subarray of size k.
    vector <int> max_of_subarrays(int *arr, int n, int k)
    {
       int j=0;
       deque <int> q;
       vector<int> ans;
       for(int i=0;i<n;i++){
           while(!q.empty() && q.back()<arr[i]){
               q.pop_back();
           }
           
           q.push_back(arr[i]);
           
           if(i-j+1 == k){
               ans.push_back(q.front());
               
               if(!q.empty() && arr[j]==q.front()){
                   q.pop_front();
               }
               
               j++;
           }
       }
       return ans;
    }
};

// { Driver Code Starts.

int main() {
	
	int t;
	cin >> t;
	
	while(t--){
	    
	    int n, k;
	    cin >> n >> k;
	    
	    int arr[n];
	    for(int i = 0;i<n;i++) 
	        cin >> arr[i];
	    Solution ob;
	    vector <int> res = ob.max_of_subarrays(arr, n, k);
	    for (int i = 0; i < res.size (); i++) 
	        cout << res[i] << " ";
	    cout << endl;
	    
	}
	
	return 0;
}  // } Driver Code Ends