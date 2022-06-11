// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{
    public:
        void nullPoints(int n, double magnets[], double getAnswer[])
    {
         for(int i=1; i<n; i++){
            double l = magnets[i-1];
            double r = magnets[i];
            while(l < r){
                double mid = l+(r-l)/2;
                double s1 = 0.00, s2 = 0.00;
                for(int j=0; j<i; j++)
                    s1 += 1/(mid-magnets[j]);
                for(int j=i; j<n; j++)
                    s2 += 1/(magnets[j]-mid);
                if(abs(s1-s2) <= 0.000001){
                    getAnswer[i-1] = mid;
                    break;
                }
                if(s1 > s2)
                    l = mid ;
                else
                    r = mid ;
            }
        }
    }
};

// { Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        double magnets[n], getAnswer[n];
        for(int i=0;i<n;i++)
        cin>>magnets[i];
        Solution ob;
        ob.nullPoints(n, magnets, getAnswer);
        
        for(int i=0; i<n-1; i++)
            printf("%0.2lf ",getAnswer[i]);
        cout<<endl;
    }
    return 0;
}  // } Driver Code Ends