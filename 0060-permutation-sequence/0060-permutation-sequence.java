class Solution {
    static int calc(int n){
        int ans = 1;
        while(n>1){
            ans *= n;
            n--;
        }
        return ans;
    }
    static String recur(int n, int k, int selectedCount, boolean[] arr, int currFactorial){
        if(selectedCount == n){
            return "";
        }
        int i=1;
        int numberToInsert = 1;
        int factorial = calc(n-selectedCount-1);
        while(numberToInsert<=n && arr[numberToInsert]){
            numberToInsert++;
        }
        while((factorial*i+currFactorial)<k){
            if(!arr[numberToInsert]){
                i++;
            }
                numberToInsert++;
        }
        while(numberToInsert<=n && arr[numberToInsert]){
            numberToInsert++;
        }
        arr[numberToInsert] = true;
        String ans = recur(n, k, selectedCount+1, arr, currFactorial+ factorial*(i-1));
        String num = String.valueOf(numberToInsert);
        return num + ans;
    }
    public String getPermutation(int n, int k) {
        String ans = "";
        boolean[] arr = new boolean[n+1];
        for(boolean i: arr){
            i = false;
        }
        ans = recur(n, k, 0, arr, 0);
        return ans;
    }
}