// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function template for C++
class Solution{
public:	
	bool sameFreq(string s)
	{
	    unordered_map<char,int> map;
	    int max=0;
	    int min = s.length()+1;
	    int minfreq = 0;
	    int maxfreq = 0;
	    
	    for(int i=0;i<min-1;i++){
	        map[s[i]]++;
	    }
	    
	    for(auto i: map){
	        if(i.second>max){
	            //cout<<i.second<<endl;
	            max = i.second;
	        }
	        if(i.second<min){
	            
	            min = i.second;
	        }
	    }
	    
	    for(auto i:map){
	        if(i.second == max){
	            maxfreq++;
	        }
	        if(i.second == min){
	            minfreq++;
	        }
	    }
	   // cout<<max<<endl;
	   // cout<<min<<endl;
	   if(min == 1 && minfreq == 1 && maxfreq+minfreq == map.size())
	   return 1;
	   if(max-min >1)
	   return 0;
	    return (maxfreq == 1 && maxfreq+minfreq == map.size() || maxfreq == map.size());
	}
};

// { Driver Code Starts.
int main(){
    int t;
    cin>>t;
    while(t--)
    {
        string s;
        cin>>s;
        Solution ob;
        cout<<ob.sameFreq(s)<<endl;
    }
}


  // } Driver Code Ends