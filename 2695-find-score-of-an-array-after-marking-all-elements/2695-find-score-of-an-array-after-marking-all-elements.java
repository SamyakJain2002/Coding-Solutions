class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey()!=0 ? a.getKey() - b.getKey() : a.getValue()-b.getValue());

        for (int i = 0; i < nums.length; i++) {
            pq.add(new Pair(nums[i], i));
        }
        long sum = 0;

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> e = pq.remove();
            int idx = e.getValue();
            int val = e.getKey();
            if (nums[idx] == 0) {
                continue;
            }
            sum += nums[idx];
            nums[idx] = 0;
            if (idx - 1 >= 0) {
                nums[idx - 1] = 0;
            }
            if (idx + 1 < nums.length) {
                nums[idx + 1] = 0;
            }
        }
        return sum;
    }
}