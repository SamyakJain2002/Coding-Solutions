// { Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

/* Link list node */
struct Node {
	int data;
	struct Node *next;
	Node(int x) {
		data = x;
		next = NULL;
	}
};


 // } Driver Code Ends
//User function Template for C++

/*Link list node 
struct Node {
	int data;
	struct Node *next;
	Node(int x) {
		data = x;
		next = NULL;
	}
};*/

class Solution
{
    public:
    Node* rev(Node* start, Node* end){
        Node* curr = start;
        Node* prev = NULL;
        Node* fow = NULL;
        while(curr && curr!=end){
            fow = curr->next;
            curr->next = prev;
            prev = curr;
            curr = fow;
        }
        return prev;
    }
    Node* reverseBetween(Node* head, int m, int n)
    {
        if(m==n)
        return head;
        
        Node* start = head;
        Node* prev = head;
        Node* end = NULL;
        int count =1;
        while(count<m && start){
            prev = start;
            start = start->next;
            count++;
        }
        end = start;

        while(count<=n && end){
            end = end->next;
            count++;
        }
        Node* temp = rev(start,end);
        if(start == head){
            head = temp;
        }
        else{
            prev->next = temp;
        }

        while(temp->next){
            temp = temp->next;
        }
        temp->next = end;
        
        return head;
    }
};

// { Driver Code Starts.

/* Function to print linked list */
void printList(struct Node *head)
{
	struct Node *temp = head;
	while (temp != NULL)
	{
		printf("%d ", temp->data);
		temp = temp->next;
	}
}



// Driver program to test above functions
int main()
{
	int T;
	cin >> T;

	while (T--)
	{
		int N, m, n;
		cin >> N>>m>>n;

		Node *head = NULL;
		Node *temp = head;

		for (int i = 0; i < N; i++) {
			int data;
			cin >> data;
			if (head == NULL)
				head = temp = new Node(data);
			else
			{
				temp->next = new Node(data);
				temp = temp->next;
			}
		}

		

        Solution ob;

		Node* newhead = ob.reverseBetween(head, m, n);
		printList(newhead);

		cout << "\n";



	}
	return 0;
}
  // } Driver Code Ends