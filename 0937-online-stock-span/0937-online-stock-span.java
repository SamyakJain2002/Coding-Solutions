class StockSpanner {
    Deque<Pair<Integer,Integer>> dq;

    public StockSpanner() {
        dq = new ArrayDeque<>();
    }
    
    public int next(int price) {
        if(dq.isEmpty()){
            dq.add(new Pair(price, 1));
            return 1;
        }
        int mspan = 1;
        while(!dq.isEmpty() && dq.peekLast().getKey()<=price){
            Pair<Integer,Integer> p = dq.pollLast();
            mspan += p.getValue();
        }
        dq.add(new Pair(price, mspan));
        return mspan;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */