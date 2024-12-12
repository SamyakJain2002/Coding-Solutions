class Node {
    // Array to hold links
    // to child nodes (0 and 1)
    Node[] links;

    // Constructor to initialize
    // the array of links
    Node() {
        links = new Node[2];
    }

    // Function to check if a child node
    // exists at a given index (0 or 1)
    boolean containsKey(int ind) {
        return (links[ind] != null);
    }

    // Function to get the child
    // node at a given index (0 or 1)
    Node get(int ind) {
        return links[ind];
    }

    // Function to set the child
    // node at a given index (0 or 1)
    void put(int ind, Node node) {
        links[ind] = node;
    }
}

// Class definition for
// Trie data structure
class Trie {
    // Pointer to the root
    // node of the trie
    Node root;

    // Constructor to initialize the
    // trie with an empty root node
    Trie() {
        root = new Node();
    }

    // Function to insert a
    // number into the trie
    void insert(int num) {
        // Start traversal
        // from the root node
        Node node = root;

        // Traverse each bit of the number
        // from the most significant bit
        // to the least significant bit
        for (int i = 31; i >= 0; i--) {
            // Extract the i-th
            // bit of the number
            int bit = (num >> i) & 1;

            // If the current node doesn't
            // have a child node at the
            // current bit, create one
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }

            // Move to the child node
            // corresponding to the current bit
            node = node.get(bit);
        }
    }

    // Function to find the maximum XOR
    // value achievable with a given number
    int findMax(int num) {
        // Start traversal from the root node
        Node node = root;

        // Initialize the maximum XOR value
        int maxNum = 0;

        // Traverse each bit of the number
        // from the most significant bit to
        // the least significant bit
        for (int i = 31; i >= 0; i--) {

            // Extract the i-th
            // bit of the number
            int bit = (num >> i) & 1;

            // If there exists a different bit
            // in the trie at the current position,
            // choose it to maximize XOR
            if (node.containsKey(1 - bit)) {

                // Set the corresponding
                // bit in the result
                maxNum = maxNum | (1 << i);
                // Move to the child node
                // with the different bit
                node = node.get(1 - bit);
            } else {

                // Move to the child node
                // with the same bit
                node = node.get(bit);
            }
        }

        // Return the maximum XOR value
        return maxNum;
    }
}

class Solution {
    public int[] maximizeXor(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];

        // Vector to store offline queries
        ArrayList<Pair<Integer, Pair<Integer, Integer>>> offlineQueries = new ArrayList<>();
        // Sort the array of numbers
        Arrays.sort(arr);

        int index = 0;

        // Convert queries to offline
        // queries and store them in a vector
        for (int[] it : queries) {
            offlineQueries.add(new Pair<>(it[1], new Pair<>(it[0], index++)));
        }

        // Sort offline queries
        // based on their end points
        Collections.sort(offlineQueries, (a,b) -> Integer.compare(a.getKey(), b.getKey()));

        // Pointer to iterate through
        // the array of numbers
        int i = 0;

        // Number of elements in the array
        int n = arr.length;

        // Create an instance of
        // the Trie data structure
        Trie trie = new Trie();

        // Process each offline query
        for (Pair<Integer, Pair<Integer, Integer>> it : offlineQueries) {
            // Insert numbers into the trie
            // until the current query's end point
            while (i < n && arr[i] <= it.getKey()) {
                trie.insert(arr[i]);
                i++;
            }

            // If there are numbers inserted
            // into the trie, find the maximum
            // XOR value for the query range
            if (i != 0)
                ans[it.getValue().getValue()] = trie.findMax(it.getValue().getKey());
            else
                // If no numbers inserted,
                // set result to -1
                ans[it.getValue().getValue()] = -1;
        }
        // Return the results
        // of all queries
        return ans;
    }
}