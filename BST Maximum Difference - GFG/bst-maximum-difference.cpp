//{ Driver Code Starts
//Initial Template for C++
#include <bits/stdc++.h>
using namespace std;
#define MAX_HEIGHT 100000

// Tree Node
struct Node {
    int data;
    Node *right;
    Node *left;

    Node(int x) {
        data = x;
        right = NULL;
        left = NULL;
    }
};

Node *insert(Node *tree, int val) {
    Node *temp = NULL;
    if (tree == NULL) return new Node(val);

    if (val < tree->data) {
        tree->left = insert(tree->left, val);
    } else if (val > tree->data) {
        tree->right = insert(tree->right, val);
    }

    return tree;
}


// } Driver Code Ends
//User function Template for C++

class Solution{
public:
    bool reach = false;
    
    int sumc(Node *root){
        if(root->left == NULL && root->right == NULL){
            return root->data;
        }
        if(!(root->left)){
            return root->data + sumc(root->right);
        }
        if(!(root->right)){
            return root->data + sumc(root->left);
        }
        return root->data + min(sumc(root->left),sumc(root->right));
    }
    
    int maxDifferenceBST(Node *root,int target){
        int val =0;
        if(root==NULL){
            return -1;
        }
        if(root->left == NULL && root->right == NULL){
            if(root->data == target){
                reach = true;
                return 0;
            }
            return reach? root->data : -1;
        }
        if(root->data > target){
            val = maxDifferenceBST(root->left,target);
            return reach? root->data + val:-1;
        }
        else if(root->data < target){
            val = maxDifferenceBST(root->right, target);
            return reach? root->data + val:-1;
        }
        else{
            reach = true;
            return -(sumc(root) - target);
            
        }
    }
};

//{ Driver Code Starts.

int main() {
    int T;
    cin >> T;
    while (T--) {
        Node *root = NULL;

        int N;
        cin >> N;
        for (int i = 0; i < N; i++) {
            int k;
            cin >> k;
            root = insert(root, k);
        }

        int target;
        cin >> target;
        Solution ob;
        cout << ob.maxDifferenceBST(root, target);
        cout << endl;
    }
}
// } Driver Code Ends