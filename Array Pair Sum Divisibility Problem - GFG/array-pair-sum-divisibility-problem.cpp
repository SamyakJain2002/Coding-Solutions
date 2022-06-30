// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
  public:
    bool canPair(vector<int> nums, int k) {
        unordered_map<int,int> m;
        int s = nums.size();
        if(s&1){
            return false;
        }
        for(auto i: nums){
            m[i%k]++;
        }
        
        for(auto i: m){
            int frem = i.first;
            int srem = (k-i.first)%k;
            if(frem == srem && m[frem]&1){
                return false;
            }
            if(m[frem] != m[srem]){
                return false;
            }
        }
        return true;
    }
};

// { Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n, k;
        cin >> n >> k;
        vector<int> nums(n);
        for (int i = 0; i < nums.size(); i++) cin >> nums[i];
        Solution ob;
        bool ans = ob.canPair(nums, k);
        if (ans)
            cout << "True\n";
        else
            cout << "False\n";
    }
    return 0;
}  // } Driver Code Ends