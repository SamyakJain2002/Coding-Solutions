// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;



 // } Driver Code Ends
class Solution
{
    public:
    //Function to insert heap.
    priority_queue<int> max;
    priority_queue<int,vector<int>,greater<int>> min;
    void insertHeap(int &x)
    {
        if(min.size()==0 || min.top() <= x)
            min.push(x);
        else
            max.push(x);
            
        balanceHeaps();
    }
    
    //Function to balance heaps.
    void balanceHeaps()
    {
        if(min.size() > max.size()+1){
            max.push(min.top());
            min.pop();
        }
        else if(min.size() < max.size()){
            min.push(max.top());
            max.pop();
        }
    }
    
    //Function to return Median.
    double getMedian()
    {
        if(min.size() == max.size()){
            return (min.top()+max.top())/2;
        }
        return (double)min.top();
    }
};


// { Driver Code Starts.

int main()
{
    int n, x;
    int t;
    cin>>t;
    while(t--)
    {
    	Solution ob;
    	cin >> n;
    	for(int i = 1;i<= n; ++i)
    	{
    		cin >> x;
    		ob.insertHeap(x);
    	    cout << floor(ob.getMedian()) << endl;
    	}
    }
	return 0;
}  // } Driver Code Ends