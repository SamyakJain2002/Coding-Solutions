class Solution {
public:
    string simplifyPath(string path) {
        path = path+' ';
        int l = path.length();
        stack<char> s;
        s.push(path[0]);
        for(int i =1;i<l-1;i++){
            if(path[i]=='/' && s.top()=='/'){
                continue;
            }
            if(i < l-1 && path[i]=='.'){
                if((path[i+1]=='/' || path[i+1] ==' ') && s.top()=='/')
                    continue;
                if(path[i+1]=='.' && (path[i+2] == '/' || path[i+2]==' ')&& s.top()=='/'){
                    if(s.size()>1){
                        s.pop();
                    }
                    while(s.top() != '/'){
                        s.pop();
                    }
                    i = i+2;
                    continue;
                }
            }
            s.push(path[i]);
        }
        if(s.top() == '/' && s.size()>1)
            s.pop();
        string ans="";
                   while(!s.empty()){
                       ans = s.top()+ans;
                       s.pop();
                   }
        return ans;
    }
};