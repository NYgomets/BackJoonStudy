import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int start;
    static int end;
    static int[] shortest;
    static boolean[] visited;
    static List<Node>[] adjList;
    static class Node {
        int next;
        int cost;

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        shortest = new int[n+1];
        for (int i=1; i<=n; i++) {
            if (i==start) {
                shortest[i] = 0;
            } else {
                shortest[i] = Integer.MAX_VALUE;
            }
        }
        visited = new boolean[n+1];

        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            st = new  StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }

        dikstra(start);
        System.out.println(shortest[end]);
    }

    private static void dikstra(int start) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int current = poll[0];

            if (visited[current]) {
                continue;
            }
            visited[current] = true;

            for (Node node : adjList[current]) {
                int next = node.next;
                int cost = node.cost;

                if (shortest[next] > shortest[current] + cost) {
                    shortest[next] = shortest[current] + cost;
                    queue.add(new int[]{next, shortest[next]});
                }
            }
        }
    }
}
