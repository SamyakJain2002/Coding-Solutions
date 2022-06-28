class Solution {
public:
   static bool compare(pair<int,int> a, pair<int,int> b){
        return a.first>b.first;
    }
    
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
       stack<pair<int,int>> s;
        vector<pair<int,int>> v;
        int n= position.size();
        for(int i=0;i<n;i++){
            v.push_back({position[i],speed[i]});
        }
        sort(v.begin(),v.end(),compare);
        int count = 0;
        for(int i=0;i<n;i++){
            if(!s.empty()){
                double a = (double)s.top().first;
                double b = (double)v[i].first;
                double s1 = (double)s.top().second;
                double s2 = (double)v[i].second;
                double pos = (s2==s1)? 0.0 : ((a*s2-b*s1)/(s2-s1));
               // cout<<pos<<" "<<v[i].first<<endl;
                if(pos < s.top().first || pos>target){
                    while(!s.empty()){
                        s.pop();
                    }
                  // cout<<v[i].first<<" "<<pos<<endl;
                    s.push(v[i]);
                    count++;
                }
            }
            else {
                s.push(v[i]);
                count++;
            }
        }
        return count;
    }
};