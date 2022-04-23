// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
// design the class in the most optimal way

class LRUCache
{
    private:

    public:
    class Node{
        public:
        int key;
        int val;
        Node* prev;
        Node* next;
        Node(int key1, int val1){
            key = key1;
            val = val1; 
        }
    };
    Node* head = new Node(-1,-1);
    Node* tail = new Node(-1,-1);
    
    void addNode(Node* newNode){
        Node* temp = head->next;
        head->next = newNode;
        newNode->next = temp;
        newNode->prev = head;
        temp->prev = newNode;
    }
    
    void delNode(Node* delNode){
        Node* temp = delNode->next;
        temp->prev = delNode->prev;
        temp->prev->next = temp;
        delete delNode;
    }
    
    int size;
    unordered_map<int, Node*> ma;
    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap)
    {
       size = cap;
head->next =tail;
tail->prev = head;
tail->next = NULL;
head->prev = NULL;
    }
    
    //Function to return value corresponding to the key.
    int get(int key)
    {
        if(ma.find(key)!=ma.end()){
            Node *res = ma[key];
            int ans = res->val;
            delNode(res);
            ma.erase(key);
            addNode(new Node(key,ans));
            ma[key] = head->next;
            return ans;
        }
        else
        return -1;
    }
    
    //Function for storing key-value pair.
    void set(int key, int value)
    {
        if(ma.find(key)!=ma.end()){
            Node *res = ma[key];
            delNode(res);
            ma.erase(key);
        } 
        else {
        if(ma.size() == size){
            ma.erase(tail->prev->key);
            delNode(tail->prev);
        }
        }
        addNode(new Node(key,value));
            ma[key] = head->next;
    }
};

// { Driver Code Starts.

int main()
{
    int t;
    cin >> t;
    while (t--)
    {

        int capacity;
        cin >> capacity;
        LRUCache *cache = new LRUCache(capacity);
        
        int queries;
        cin >> queries;
        while (queries--)
        {
            string q;
            cin >> q;
            if (q == "SET")
            {
                int key;
                cin >> key;
                int value;
                cin >> value;
                cache->set(key, value);
            }
            else
            {
                int key;
                cin >> key;
                cout << cache->get(key) << " ";
            }
        }
        cout << endl;
    }
    return 0;
}
  // } Driver Code Ends