class Solution {
public:
    void backtrack(vector<string>& ans, int open, int close, int n, string cur){
        if(close == n){
            ans.push_back(cur);
        }
        if(open<n){
            backtrack(ans, open+1, close, n, cur+'(');
        }
        if(close<open){
            backtrack(ans, open, close+1, n, cur+')');
        }
    }
    vector<string> generateParenthesis(int n) {
        int open =0;int close=0;
        vector<string> ans;
        string s="";
        backtrack(ans, 0,0,n, s);
           return ans;
    }
};