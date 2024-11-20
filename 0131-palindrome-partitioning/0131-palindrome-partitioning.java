class Solution {
    static boolean isPalindrome(String str){
        int i = 0, j = str.length() - 1;

        // While there are characters to compare
        while (i < j) {

            // If there is a mismatch
            if (str.charAt(i) != str.charAt(j))
                return false;

            // Increment first pointer and
            // decrement the other
            i++;
            j--;
        }

        // Given string is a palindrome
        return true;
    }
    static void recur(String s, List<List<String>> ans, List<String> curr, int idx, String check){
        if(idx == s.length()){
            if (curr.size() >0){
                ans.add(new ArrayList<>(curr));
                return;
            }
        }

        for(int i=idx;i<s.length();i++){
            check = check + s.charAt(i);
            if(!isPalindrome(check)){
                continue;
            }
            curr.add(check);
            recur(s, ans, curr, i+1, "");
            curr.remove(curr.size()-1);
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        recur(s, ans, curr, 0,"");
        return ans;
    }
}