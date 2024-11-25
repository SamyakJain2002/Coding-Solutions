class Solution {
    boolean algo(String source, String target){
        if(source.equals("") || target.equals("")){
            return false;
        }
        int m = target.length();
        int power = 1;
        int base = 1000000;
        for(int i=0;i<m;i++){
            power = (power*31)%base;
        }
        int hash = 0;
        int targethash = 0;
        for(int i=0;i<m;i++){
            targethash = (targethash*31+target.charAt(i))%base;
        }

        for(int i=0;i<source.length();i++){
            hash = (hash*31+source.charAt(i))%base;
            if(i<m-1){
                continue;
            }
            if(i>=m){
                hash = (hash - source.charAt(i-m)*power)%base;
            }
            if(hash<0)
                hash+=base;
            if(hash == targethash){
                if(target.equals(source.substring(i-m+1, i+1))){
                    return true;
                }
            }
        }
        return false;
    }
    public int repeatedStringMatch(String a, String b) {
        if(a.equals(b)){
            return 1;
        }
        int count  = 1;
        String source = a;
        while(source.length()<b.length()){
            source = source + a;
            count++;
        }
        if(source.equals(b)){
            return count;
        }
        if(algo(source, b)) return count;
        if(algo(source+a, b)) return count+1;
        return -1;
    }
}