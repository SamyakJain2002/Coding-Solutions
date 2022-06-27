// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
public:
    void fill(vector<vector<int>>& image, int sr, int sc, int newColor, int oldColor, int n, int m){
        if(sr<0 || sr >= n || sc <0 || sc >= m || image[sr][sc] != oldColor){
            return;
        }
        image[sr][sc] = newColor;
        fill(image, sr+1, sc, newColor, oldColor, n, m);
        fill(image, sr-1, sc, newColor, oldColor, n, m);
        fill(image, sr, sc+1, newColor, oldColor, n, m);
        fill(image, sr, sc-1, newColor, oldColor, n, m);
    }

    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(newColor == image[sr][sc])
        return image;
        int n = image.size();
        int m = image[0].size();
        fill(image, sr,sc,newColor, image[sr][sc],n,m);
        return image;
    }
};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n, m;
		cin >> n >> m;
		vector<vector<int>>image(n, vector<int>(m,0));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++)
				cin >> image[i][j];
		}
		int sr, sc, newColor;
		cin >> sr >> sc >> newColor;
		Solution obj;
		vector<vector<int>> ans = obj.floodFill(image, sr, sc, newColor);
		for(auto i: ans){
			for(auto j: i)
				cout << j << " ";
			cout << "\n";
		}
	}
	return 0;
}  // } Driver Code Ends