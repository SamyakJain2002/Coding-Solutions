class Solution {
    String rle(int n){
        if(n == 1){
            return "1";
        }
        String a = rle(n-1);
        int i=0, len = a.length();
        int count = 0;
        String ans = "";
        while(i<len){
            if(i!=0 && a.charAt(i)!=a.charAt(i-1)){
                ans = ans + Integer.toString(count) + a.charAt(i-1);
                count = 1;
            }else{
                count++;
            }
            i++;
        }
        ans = ans + Integer.toString(count)+a.charAt(i-1); 
        return ans;
    }
    public String countAndSay(int n) {
        return rle(n);
    }
}