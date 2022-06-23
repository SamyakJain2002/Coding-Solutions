// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{
	public:
	int TotalWays(int N)
	{
	    int dp[N]={-1};
	    dp[0] = 2;
	    dp[1] = 3;
	    long mod = 1000000007;
	    for(int i=2;i<N;i++){
	        dp[i] = (dp[i-1] + dp[i-2])%mod;
	    }
	    int ans = ((dp[N-1]%mod)*(dp[N-1]%mod))%mod;
	    return ans;
	}
};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int N;
		cin >> N;
		Solution ob;
		int ans = ob.TotalWays(N);
		cout << ans <<"\n";
	}
	return 0;
}  // } Driver Code Ends