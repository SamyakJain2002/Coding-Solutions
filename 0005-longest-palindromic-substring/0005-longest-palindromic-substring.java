class Solution {
    String expand(int l, int r, String s){
        while(l>=0 && r < s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1, r);
    } 
    public String longestPalindrome(String s) {
        int n = s.length();
        String sub1 ="", res="";
        for(int i=0;i<=n-1;i++){
            sub1 = expand(i,i,s);
            res = (res.length()<sub1.length())?sub1:res;
            sub1 = expand(i,i+1,s);
            res = (res.length()<sub1.length())?sub1:res;
        }
        return res;
    }
}