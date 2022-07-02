// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution
{
    public:
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    string smallestWindow (string s, string p)
    {
        unordered_map<char,int> map;
        int plen = p.length();
        for(int i=0;i<plen;i++){
            map[p[i]]++;
        }
        plen = map.size();
        int curlen=0;
        int head = -1;
        int tail = 0;
        pair<int,int> minlen = {s.length()+1,-1};
        
        while(tail<s.length()){
            
            while((plen!=curlen) && (head+1<s.length())){
                if(map.find(s[++head])!= map.end()){
                    map[s[head]]--;
                   
                    if(map[s[head]] == 0){
                        curlen++;
                    }
                }
            }
            if((curlen == plen) && minlen.first>(head-tail+1)){
                minlen = {head-tail+1, tail};
            }
            if(map.find(s[tail])!=map.end()){
                map[s[tail]]++;
                if(map[s[tail]]>0){
                    curlen--;
                }
            }
            tail++;
        }
        
        string ans = "";
        if(minlen.second == -1){
            return "-1";
        }
        for(int i= minlen.second;i<minlen.second+minlen.first;i++){
            ans = ans + s[i];
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
        string s;
        cin>>s;
        string pat;
        cin>>pat;
        Solution obj;
        cout<<obj.smallestWindow(s, pat)<<endl;
        
    }
	return 0;
}  // } Driver Code Ends