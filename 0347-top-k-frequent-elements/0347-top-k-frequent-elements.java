class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> freq = new ArrayList<>();
        for (int i = 0; i < nums.length+1; i++) {
            freq.add(new ArrayList<>());
        }
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

	for (int n : nums) {
		frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
	}
    for(int key: frequencyMap.keySet()){
        int frequency = frequencyMap.get(key);
        freq.get(frequency).add(key);
    }
    int [] ans = new int[k];
    int idx =0;
    for(int i=freq.size()-1;i>=0 && idx<k;i--){
        if(freq.get(i).size()>0){
            for(int j: freq.get(i)){
                if(idx<k){
                    ans[idx++] = j;  
                }
            }
        }
    }
    return ans;
    }
}