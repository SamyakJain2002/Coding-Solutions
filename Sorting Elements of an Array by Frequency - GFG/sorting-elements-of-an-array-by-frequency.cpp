#include <bits/stdc++.h>
using namespace std;

unordered_map<int,int> m;

bool compare(int a, int b){
    if(m[a]>m[b]){
        return true;
    }
    else if(m[a] == m[b]){
        return a<b;
    }
    else
        return false;
}
int main() {
	int t;
	cin>>t;
	while(t--){
	    int n;
	    cin>>n;
	    int a[n];
	    for(int i=0;i<n;i++){
	        cin>>a[i];
	        m[a[i]]++;
	    }
	    sort(a,a+n,compare);
	    for(int i=0;i<n;i++){
	        cout<<a[i]<<" ";
	    }
	    cout<<endl;
	    m.clear();
	}
	return 0;
}