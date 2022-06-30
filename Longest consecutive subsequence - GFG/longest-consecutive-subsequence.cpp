// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution{
  public:
    // arr[] : the input array
    // N : size of the array arr[]
    
    //Function to return length of longest subsequence of consecutive integers.
    int findLongestConseqSubseq(int A[], int N)
    {
      map<int,int> m;
      int min = INT_MAX;
      for(int i=0;i<N;i++){
          m[A[i]]++;
          if(A[i]<min){
              min = A[i];
          }
      }
      
      m.erase(min);
      int maxlen =0;
      int count = 1;
      for(auto i: m){
          if(i.first == min+1){
              count++;
              min = i.first;
          }
          else{
             // cout<<i->first<<" "<<count<<endl;
              maxlen = max(count,maxlen);
              min = i.first;
              count = 1;
          }
      }
      maxlen = max(count,maxlen);
      return maxlen;
    }
};

// { Driver Code Starts.
 
// Driver program
int main()
{
 int  t,n,i,a[100001];
 cin>>t;
 while(t--)
 {
  cin>>n;
  for(i=0;i<n;i++)
  cin>>a[i];
  Solution obj;
  cout<<obj.findLongestConseqSubseq(a, n)<<endl;
 }
      
    return 0;
}  // } Driver Code Ends