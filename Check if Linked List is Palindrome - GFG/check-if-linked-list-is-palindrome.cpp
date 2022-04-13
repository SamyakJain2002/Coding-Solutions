// { Driver Code Starts
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <stack>
using namespace std;
/* Link list Node */
struct Node {
  int data;
  struct Node *next;
  Node(int x) {
    data = x;
    next = NULL;
  }
};




 // } Driver Code Ends
/*
struct Node {
  int data;
  struct Node *next;
  Node(int x) {
    data = x;
    next = NULL;
  }
};
*/

class Solution{
  public:
struct Node* reverse(struct Node* head){
        Node* cur = head;
        Node* prev = NULL;
        Node* forw = NULL;
        while(cur!=NULL){
            forw = cur->next;
            cur->next = prev;
            prev = cur;
            cur = forw;
        }
        return prev;
    }
    //Function to check whether the list is palindrome.
    bool isPalindrome(Node *head)
    {
        Node* slow =head;
        Node* fast = head;
        while(fast!=NULL){
            slow = slow->next;
            
            fast =(fast->next ==NULL)?fast->next : fast->next->next;
        }
        Node* end = reverse(slow);
        Node* beg = head;
        
        while(beg != end && beg!=NULL && end!=NULL){
            if(beg->data != end->data){
                return false;
            }
            beg = beg->next;
            end = end->next;
        }
        return true;
    }
};



// { Driver Code Starts.
/* Driver program to test above function*/
int main()
{
  int T,i,n,l,firstdata;
    cin>>T;
    while(T--)
    {
        
        struct Node *head = NULL,  *tail = NULL;
        cin>>n;
        // taking first data of LL
        cin>>firstdata;
        head = new Node(firstdata);
        tail = head;
        // taking remaining data of LL
        for(i=1;i<n;i++)
        {
            cin>>l;
            tail->next = new Node(l);
            tail = tail->next;
        }
    Solution obj;
   	cout<<obj.isPalindrome(head)<<endl;
    }
    return 0;
}

  // } Driver Code Ends