// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    vector<int> changeBits(int N) {
        vector<int> ans;
        if(N==0){
            ans.push_back(-1);
            ans.push_back(-1);
            return ans;
        }
        int bit =0;
        int newn=0;
        int temp = N;
        while(temp){
            bit++;
            newn = newn*2 + 1;
            temp = temp >> 1;
        }
        ans.push_back(newn-N);
        ans.push_back(newn);
        return ans;
        
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin>>N;
        Solution ob;
        auto ans = ob.changeBits(N);
        cout<<ans[0]<<" "<<ans[1]<<endl;
    }
    return 0;
}  // } Driver Code Ends