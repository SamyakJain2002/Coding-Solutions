// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
/*You are required to complete this function*/

class Solution{
    public:
    int maxLen(vector<int>&A, int n)
    {   
        unordered_map<int,int> m;
        int sum = 0;
        int length = 0;
        for(int i=0;i<n;i++){
            sum = sum+A[i];
            if(m[sum] == 0){
                m[sum] = i+1;   
            }
            if(sum == 0){
                length = i+1;
            }
            if(m[sum] > 0){
                length = max(length,i+1-m[sum]);
            }
        }
        return length;
    }
};


// { Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int m;
        cin>>m;
        vector<int> array1(m);
        for (int i = 0; i < m; ++i){
            cin>>array1[i];
        }
        Solution ob;
        cout<<ob.maxLen(array1,m)<<endl;
    }
    return 0; 
}


  // } Driver Code Ends