class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            if(stack.empty()){
                stack.push(i);
            }else{
                if(nums2[stack.peek()] >= nums2[i]){
                    stack.push(i);
                }else{
                    while(!stack.empty() && nums2[stack.peek()] < nums2[i]){
                        int j = stack.peek();
                        hm.put(nums2[j], nums2[i]);
                        stack.pop(); 
                    }
                    stack.push(i);
                }
            }
        }
        int []ans = new int[nums1.length];
        for(int i=0;i< nums1.length;i++){
            if(hm.containsKey(nums1[i])){
                ans[i] = hm.get(nums1[i]);
            }else{
                ans[i] = -1;
            }
        }
        return ans;
    }
}