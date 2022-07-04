// { Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int minVal(int a, int b) {
        int count=0;
        int ans =0;
        while(b){
            if(b&1){
                count++;
            }
            b = b>>1;
        }
        //cout<<count<<endl;
        int temp = a;
        int counta =0;
        
        temp = temp>>1;
        while(temp){
            counta++;
            temp = temp>>1;
        }
       //cout<<counta<<endl;
       if(count>counta){
           while(count--){
               ans = ans + (1<<count);
           }
           return ans;
       }
        while(count && counta>=0){
            if(a&(1<<counta)){
                ans = ans + (1<<counta);
                count--;
            }
            counta--;
        }
        //cout<<count<<endl;
        //cout<<ans<<endl;
        temp = ans;
        int pos= 0;
        while(count){
            if(temp&1){
                pos++;
            }
            else{
                ans = ans + (1<<pos);
                count--;
                pos++;
            }
            temp = temp>>1;
        }
        return ans;
    }
};

// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int a, b;
        cin >> a >> b;

        Solution ob;
        cout << ob.minVal(a, b);

        cout << "\n";
    }

    return 0;
}  // } Driver Code Ends