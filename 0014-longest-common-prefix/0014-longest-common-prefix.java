class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        Arrays.sort(strs);
        int n = strs.length-1;
        int idx = 0;
        int i = 0;
        String ans = "";
        char c = ' ';
        while(idx < strs[i].length() && idx<strs[n].length()){
            c = strs[i].charAt(idx);
            if(c != strs[n].charAt(idx)){
                return ans;
            } else{
                ans = ans + c;
            }
            idx++;
        }
        return ans;
    }
}