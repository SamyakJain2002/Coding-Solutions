class Solution {
    int[] computeLps(String pattern){
        int m = pattern.length();
        int []lps = new int[m];
        int l=0, i = 1;
        for(int j: lps){
            j = 0;
        }
        while(i<m){
            if(pattern.charAt(i) == pattern.charAt(l)){
                l++;
                lps[i] = l;
                i++;
            }else{
                if(l!=0){
                    l = lps[l-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return -1;
        }
       int [] lps = computeLps(needle);

       int i=0,j=0;
       int n = haystack.length();
       int m = needle.length();
       while(i<n){
        if(haystack.charAt(i) == needle.charAt(j)){
            i++;
            j++;
        }
        if(j==m){
            return i-j;
        }else if(i < n && haystack.charAt(i) != needle.charAt(j)){
            if(j != 0){
                j = lps[j-1];
            }else{
                i++;
            }
        }
       }
       return -1;
    }
}