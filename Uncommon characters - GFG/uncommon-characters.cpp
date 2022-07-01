// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends

class Solution
{
    public:
        string UncommonChars(string A, string B)
        {
            int a[26] = {};
            int b[26] = {};
            for(int i=0;i<A.length();i++)
           {
               a[A[i]-'a']++;
           }
           for(int i=0;i<B.length();i++)
           {
               b[B[i]-'a']++;
           }
           string ans="";
           for(int i=0;i<26;i++)
           {
               if(a[i]==0 && b[i]>0)
               {
                   ans=ans+(char)(i+'a');
               }
               else if(a[i]>0 && b[i]==0)
              {
                  ans=ans+(char)(i+'a');
              }
           }
           if(ans.length()==0)
           {
               return "-1";
           }
           return ans;
        }
};



// { Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        string A,B;
        cin>>A;
        cin>>B;
        Solution ob;
        cout<<ob.UncommonChars(A, B);
        cout<<endl;
    }
    return 0;
}  // } Driver Code Ends