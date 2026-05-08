import java.util.*;

class Solution {
    static List<Integer>[] adjList;
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            adjList[a].add(b);
            adjList[b].add(a);
        }
        
        for (int[] wire : wires) {
            visited= new boolean[n+1];
            
            int cutA = wire[0];
            int cutB = wire[1];
            
            int check1 = bfs(1, cutA, cutB);
            int check2 = n-check1;
            
            int num = Math.abs(check1 - check2);
            answer = Math.min(answer, num);
        }
        
        return answer;
    }
    
    static public int bfs(int start, int cutA, int cutB) {
        int result = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            for (int next : adjList[cur]) {
                
                if (cur==cutA && next==cutB) {
                    continue;
                }
                if (cur==cutB && next==cutA) {
                    continue;
                }
                
                if (!visited[next]) {
                    visited[next] = true;
                    result++;
                    queue.add(next);
                }
            }
        }
        
        return result;
    }
}