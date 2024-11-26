class Solution {
    public int compareVersion(String version1, String version2) {
        int n1 = Math.max(version1.length(), version2.length());
        int n2 = Math.min(version1.length(), version2.length());
        int l1 = version1.length(), l2 = version2.length();
        int i = 0, k = 0;
        while (i < l1 && k<l2) {
            int c = 0, d = 0;
            int j = i;
            while(j<l1 && version1.charAt(j)!='.'){
                j++;
            }
            if(j!=i){
                c = Integer.parseInt(version1.substring(i,j));
                i = j+1;
            }
            j = k;
            while(j<l2 && version2.charAt(j)!='.'){
                j++;
            }
            if(j!=k){
                d = Integer.parseInt(version2.substring(k,j));
                k = j+1;
            }
            if (c > d) {
                return 1;
            } else if (c < d) {
                return -1;
            }
        }
        while(k<l2){
            if(version2.charAt(k)!='.' && version2.charAt(k)!='0'){
                return -1;
            }
            k++;
        }
        while(i<l1){
            if(version1.charAt(i)!='.' && version1.charAt(i)!='0'){
                return 1;
            }
            i++;
        }
        return 0;
    }
}