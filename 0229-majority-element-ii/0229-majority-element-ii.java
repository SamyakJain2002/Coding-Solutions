class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int e1 = 0, e1count = 0, e2 = 0, e2count = 0;
        int curr = 0, currcount = 0;

        for (int i : nums) {
            if (curr != i) {
                if (currcount > Math.min(e1count, e2count)) {
                    if (e1count > e2count) {
                        e2 = curr;
                        e2count = currcount;
                    } else {
                        e1 = curr;
                        e1count = currcount;
                    }
                }
                curr = i;
                currcount = 1;
            } else {
                currcount++;
            }
        }
        if (currcount > Math.min(e1count, e2count)) {
            if (e1count > e2count) {
                e2 = curr;
                e2count = currcount;
            } else {
                e1 = curr;
                e1count = currcount;
            }
        }
        List<Integer> ans = new ArrayList<Integer>();

        if (e1count > nums.length / 3) {
            ans.add(e1);
        }
        if (e2count > nums.length / 3) {
            ans.add(e2);
        }
        return ans;
    }
}