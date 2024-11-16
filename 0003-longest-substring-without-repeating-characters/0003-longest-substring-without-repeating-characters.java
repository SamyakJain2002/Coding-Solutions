class Solution {
    public int lengthOfLongestSubstring(String s) {
        System.out.println(s.length());
        if(s.length() == 0){
            return 0;
        }
        HashMap<Character,Integer> mp = new HashMap<>();
        int i=0, j =0;
        int maxlen = 1;
        while(j< s.length()){
            if(mp.containsKey(s.charAt(j))){
                mp.put(s.charAt(j), mp.get(s.charAt(j))+1);
            }else{
                mp.put(s.charAt(j),1);
            }
            
            while(mp.get(s.charAt(j))>1){
                mp.put(s.charAt(i), mp.get(s.charAt(i))-1);
                i++;
            }
            j++;
            maxlen = Math.max(maxlen, (j-i));
        }
        return maxlen;
    }
}