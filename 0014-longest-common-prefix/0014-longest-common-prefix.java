class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        int n = strs.length;
        int idx = 0;
        int i = 0;
        String ans = "";
        char c = ' ';
        while(idx < strs[i].length()){
            if(i == 0){
                c = strs[i].charAt(idx);
            } else if(c != strs[i].charAt(idx)){
                return ans;
            } 
            if(i == n-1){
                ans = ans + c;
                idx++;
            }
            i = (i+1)%n;
        }
        return ans;
    }
}