// { Driver Code Starts
#include <iostream>
using namespace std;


 // } Driver Code Ends
class Solution{
public:
    long posIntSol(string s)
    {
        int l = s.length();
        int n =1;int k=0;
        for(int i=0;i<l;i++){
            if(s[i]=='+'){
                n++;
            }
            if(s[i]=='='){
                k = stoi(s.substr(i+1,l-i-1));
                break;
            }
        }

        if(k<n)
        return 0;

        long ans=1;
        for(int i=1;i<=n-1;i++){
            ans = ans*(k-i)/i;
        }
        return ans;
    }
};

// { Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    for(int i=0;i<t;i++)
    {
        string s;
        cin>>s;
        Solution ob;
        cout<<ob.posIntSol(s)<<endl;
    }
    return 0;
}
  // } Driver Code Ends