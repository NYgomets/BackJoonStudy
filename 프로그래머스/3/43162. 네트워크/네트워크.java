import java.util.*;

class Solution {
    static List<Integer>[] adjList;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        adjList = new ArrayList[n];
        for (int i=0; i<n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i != j) {
                    if (computers[i][j] == 1) {
                        adjList[i].add(j);
                        adjList[j].add(i);
                    }
                }
            }
        }
        
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                answer++;
                bfs(i);
            }
        }
        return answer;
    }
    
    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            if (visited[current]) {
                continue;
            }
            visited[current] = true;
            
            for (int next : adjList[current]) {
                queue.add(next);
            }
        }
    }
}