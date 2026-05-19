import java.util.*;

class Solution {
    static int[] shortest;
    static List<Node>[] adjList;
    static class Node {
        int next;
        int cost;
        
        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        shortest = new int[N+1];
        for (int i=2; i<=N; i++) {
            shortest[i] = Integer.MAX_VALUE;
        }
        adjList = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];
            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }
        
        dikstra();
        for (int i=1; i<=N; i++) {
            if (shortest[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
    
    static public void dikstra() {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.add(new int[]{1, 0});
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cur = poll[0];
            
            for (Node node : adjList[cur]) {
                int next = node.next;
                int cost = node.cost;
                
                if (shortest[next] > shortest[cur] + cost) {
                    shortest[next] = shortest[cur] + cost;
                    queue.add(new int[]{next, shortest[next]});
                }
            }
        }
    }
}