// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


vector<int> reaching_height(int n, int a[]) ;

int main() {
	int t;
	cin >> t;
	while (t-- > 0) {
	    int n; 
	    cin >> n;
	    int a[n];
	    for (int i = 0; i < n; i++) 
	        cin >> a[i];
	    vector<int> v;
	    v = reaching_height(n,a);
	
	    if(v.size()==1 and v[0] == -1){
	        cout << "Not Possible\n";
	    }
	    else{
	    for(int i:v)
	        cout << i << " ";
	    cout << endl;}
	    
	}
	return 0;
}// } Driver Code Ends


//User function Template for C++

vector<int> reaching_height(int n, int a[]) {
    sort(a,a+n);
    
    if(a[n-1] == a[0] && n>1){
        return vector<int> {-1};
    }
    vector<int> ans;
    long long max = a[n-1]+!1;
    int small = 0;
    int large = n-1;
    int i=0;
    while(small<=large){
        if(i&1){
            ans.push_back(a[small]);
            small++;
        }
        else{
            ans.push_back(a[large]);
            large--;
        }
        i++;
    }
    return ans;
}
