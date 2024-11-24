class FreqStack {
    HashMap<Integer, Integer> freqMap;
    HashMap<Integer, Stack<Integer>> freqStack;
    int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        freqStack = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int freq = 0;
        if(freqMap.containsKey(val)){
            freq = freqMap.get(val);
        }
        freqMap.put(val, ++freq);
        maxFreq = Math.max(maxFreq, freq);
        Stack<Integer> st;
        if(freqStack.containsKey(freq)){
            st = freqStack.get(freq);
        }else{
            st = new Stack<>();
        }
        st.push(val);
        freqStack.put(freq, st);
    }
    
    public int pop() {
        Stack<Integer> st;
        if(freqStack.get(maxFreq).empty()){
            maxFreq--;
        }
        st = freqStack.get(maxFreq);
        int ans = st.peek(); st.pop();
        freqStack.put(maxFreq, st);
        int freq = freqMap.get(ans);
        freqMap.put(ans, --freq);
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */