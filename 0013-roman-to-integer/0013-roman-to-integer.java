class Solution {
    int getNumber(char c){
        if(c == 'I'){
            return 1;
        }
        if(c == 'V'){
            return 5;
        }
        if(c == 'X'){
            return 10;
        }
        if(c == 'L'){
            return 50;
        }
        if(c == 'C'){
            return 100;
        }
        if(c == 'D'){
            return 500;
        }
        if(c == 'M'){
            return 1000;
        }
        return -1;
    }
    public int romanToInt(String s) {
        int ans=0;
        int n = s.length();
        for(int i=0;i<n;i++){
            int curr = getNumber(s.charAt(i));
            if(i<n-1 && curr<getNumber(s.charAt(i+1))){
                ans -= curr;
            }else{
                ans += curr;
            }
        }
        return ans;
    }
}