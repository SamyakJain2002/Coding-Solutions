// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends


class Solution
{
    public:
    //Function to check if brackets are balanced or not.
    bool ispar(string x)
    {
        stack<char> s;
        int size=0;
        int l = x.length();
        for(int i=0;i<l;i++){
            if(x[i] == '[' || x[i]=='{' || x[i]=='('){
                s.push(x[i]);
                size++;
            }
            else{
                if(size!=0){
                if((s.top() =='[' && x[i] == ']')||(s.top() =='{' && x[i] == '}')||(s.top() =='(' && x[i] == ')')){
                    
                    s.pop();
                    size--;
                }
                else
                {
                return false;
                }
                }
                else{
                    return false;
                }
            }
        }
        if(s.size()>0){
            return false;
        }
        return true;
    }

};

// { Driver Code Starts.

int main()
{
   int t;
   string a;
   cin>>t;
   while(t--)
   {
       cin>>a;
       Solution obj;
       if(obj.ispar(a))
        cout<<"balanced"<<endl;
       else
        cout<<"not balanced"<<endl;
   }
}  // } Driver Code Ends