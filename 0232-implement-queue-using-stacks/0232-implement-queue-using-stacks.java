class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
       s1.push(x);
    }
    
    public int pop() {
        int ans;
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.peek());
                s1.pop();
            }
        }
        ans = s2.peek();
            s2.pop();
        return ans;
    }
    
    public int peek() {
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.peek());
                s1.pop();
            }
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */