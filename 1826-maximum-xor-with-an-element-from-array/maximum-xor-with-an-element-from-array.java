
class Node {
    Node[] links = new Node[2];

    boolean containsKey(int ind) {
        return links[ind] != null;
    }

    Node get(int ind) {
        return links[ind];
    }

    void put(int ind, Node node) {
        links[ind] = node;
    }
}

class Trie {
    private Node root;

    Trie() {
        root = new Node();
    }

    void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    int findMax(int num) {
        Node node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                maxNum = maxNum | (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] ans = new int[q];
        Arrays.sort(nums);
        int[][] offlineQueries = new int[q][3];
        for (int i = 0; i < q; i++) {
            offlineQueries[i][0] = queries[i][1]; 
            offlineQueries[i][1] = queries[i][0]; 
            offlineQueries[i][2] = i;              
        }
        Arrays.sort(offlineQueries, (a, b) -> Integer.compare(a[0], b[0]));

        Trie trie = new Trie();
        int numsIdx = 0;
        for (int i = 0; i < q; i++) {
            int limit = offlineQueries[i][0];
            int x = offlineQueries[i][1];
            int originalIdx = offlineQueries[i][2];

            while (numsIdx < n && nums[numsIdx] <= limit) {
                trie.insert(nums[numsIdx]);
                numsIdx++;
            }
            if (numsIdx == 0) {
                ans[originalIdx] = -1;
            } else {
                ans[originalIdx] = trie.findMax(x);
            }
        }

        return ans;
    }
}