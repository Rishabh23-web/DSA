class Solution {
public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. Build the Adjacency List
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int pre = edge[1];
            adj.get(pre).add(course);
            indegree[course]++;
        }

        // 2. Add nodes with 0 indegree to Queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        // 3. BFS (Kahn's)
        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;

            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // If we processed all nodes, no cycle exists
        return count == numCourses;
    }
}