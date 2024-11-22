class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(minHeap.size()==0){
            minHeap.add(num);
        }else{
            if(minHeap.peek() < num){
                minHeap.add(num);
            }else{
                maxHeap.add(num);
            }
        }

        if(minHeap.size()-maxHeap.size()>1){
            maxHeap.add(minHeap.peek());minHeap.poll();
        }else if(maxHeap.size()-minHeap.size()>0){
            minHeap.add(maxHeap.peek());maxHeap.poll();
        }

    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return ((double)(minHeap.peek()+maxHeap.peek()))/2;
        }
        return minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */