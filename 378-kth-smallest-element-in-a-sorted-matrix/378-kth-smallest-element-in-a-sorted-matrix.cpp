class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        priority_queue<int> q;
        for(auto i: matrix){
            for(auto j: i){
                q.push(j);
                if(q.size()>k){
                    q.pop();
                }
            }
        }
        return q.top();
    }
};