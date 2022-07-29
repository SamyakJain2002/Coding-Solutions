class Solution {
public:
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        vector<string> ans;
        unordered_map<char,char> m;
        unordered_map<char,char> m1;
        int l = pattern.length();
        
        for(auto i: words){
            for(int j=0;j<l;j++){
                if(m.find(pattern[j]) == m.end()){
                    if(m1.find(i[j]) == m1.end()){
                        m1[i[j]] = pattern[j];
                        m[pattern[j]] = i[j];
                    }
                    else{
                         m1.clear();
                         m.clear();
                         break;
                    }
                 
                }
                else if(m[pattern[j]] != i[j] || m1[i[j]] != pattern[j]){
                    m.clear();
                    m1.clear();
                    break;
                }
            }
            if(m.size() > 0){
                ans.push_back(i);
                m.clear();
                m1.clear();
            }
        }
        return ans;
        }
    
};