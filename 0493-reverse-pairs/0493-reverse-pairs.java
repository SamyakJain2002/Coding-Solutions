class Solution {
    static int countPair(int []arr1, int []arr2, int n1, int n2){
        int i=0, j=0;
        int count = 0;
        while(i<n1 && j<n2){
            if(arr1[i] > ((long)arr2[j] * 2)){
                count += n1-i;
                j++;
            }else{
                i++;
            }
        }
        return count;
    }
    static int merge(int []nums, int l, int mid, int r){
        int n1 = mid+1-l;
        int n2 = r-mid;
        int []arr1 = new int[n1], arr2 = new int[n2];
        for(int i=0;i<n1;i++){
            arr1[i] = nums[l+i];
        }

        for(int i=0; i<n2;i++){
            arr2[i] = nums[mid+i+1];
        }
        int count = countPair(arr1, arr2, n1, n2);
        int i=0, j=0, k=0;
        while(i<n1 && j<n2){
            if(arr1[i]<=arr2[j]){
                nums[l+k] = arr1[i];
                i++;
            }else{
                nums[l+k] = arr2[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            nums[l+k] = arr1[i];
            i++;
            k++;
        }
        while(j<n2){
            nums[l+k] = arr2[j];
            j++;
            k++;
        }
        return count;
    }

    static int mergeSort(int []nums, int l, int r){
        if(l>=r){
            return 0;
        }
        int mid = (l+r)/2;
        int c1 = mergeSort(nums, l,mid);
        int c2 = mergeSort(nums, mid+1, r);
        int c3 = merge(nums, l, mid, r);

        return c1+c2+c3;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}