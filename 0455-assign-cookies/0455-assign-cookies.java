class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gsize = g.length;
        int ssize = s.length;
        int i=0, j=0, ans = 0;
        while((i<gsize) && (j < ssize)){
            if(g[i]<=s[j]){
                ans++; i++; j++;
            } else{
                j++;
            }
        }
        return ans;
    }
}