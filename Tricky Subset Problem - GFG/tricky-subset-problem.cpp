// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution{
public:
    int isPossible(long long S, long long N, long long X, long long A[])
    {
        vector<long long> sum;
        long long s1=S;
        sum.push_back(S);
        long long j=0;
        for(long long i=0;i<N;i++){
            sum.push_back(s1+A[i]);
            if(s1+A[i]>=X)
            break;
            s1 = s1+sum.back();
        }
        if(sum.back() == X)
        return 1;
        N = sum.size();
        s1 = 0;
        for(long long i=N-1;i>=0;i--){
            if(sum[i]<=X)
            {
                X = X-sum[i];
            }
            if(X == 0){
                return 1;
            }
        }
        return 0;
    }
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        long long S, N, X;
        cin>>S>>N>>X;
        long long A[N];
        for(long long i = 0;i < N;i++)
            cin>>A[i];
        
        Solution ob;
        if(ob.isPossible(S, N, X, A))
            cout<<"yes\n";
        else
            cout<<"no\n";
    }
    return 0;
}  // } Driver Code Ends