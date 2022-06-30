// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{

	public:
	
	int findSwapValues(int A[], int n, int B[], int m)
	{
        int sum1=0;
        int sum2=0;
        unordered_map<int,int> ma;
        int diff =0;
        
        for(int i=0;i<n;i++){
            ma[A[i]]++;
            sum1 = sum1+A[i];
        }
        for(int j = 0;j<m;j++){
            sum2 = sum2+B[j];
        }
         diff= (sum2-sum1);
         if(diff&1){
             return -1;
         }
         diff = diff/2;
         for(int i=0;i<m;i++){
             if(ma[B[i]-diff] > 0)
             return 1;
         }
         return -1;
	}
 

};

// { Driver Code Starts.

int main() 
{
   	
   	int t;
    cin >> t;
    while (t--)
    {
    	int n,m;
        cin>>n>>m;
        int a[n];
        int b[m];
        for(int i=0;i<n;i++)
            cin>>a[i];
        for(int i=0;i<m;i++)
            cin>>b[i];
        

        Solution ob;
        cout <<  ob.findSwapValues(a, n, b, m);
	    cout << "\n";
	     
    }
    return 0;
}





  // } Driver Code Ends