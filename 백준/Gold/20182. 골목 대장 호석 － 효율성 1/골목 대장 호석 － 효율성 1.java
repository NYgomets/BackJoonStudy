import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int start;
    static int end;
    static int c;
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
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            adjList[x].add(new Node(y, z));
            adjList[y].add(new Node(x, z));
        }

        dikstra(start);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static void dikstra(int start) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.add(new int[]{start, 0, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int current = poll[0];
            int resultCost = poll[1];
            int curTotal = poll[2];

            if (current == end) {
                result = Math.min(result, resultCost);
            }

            if (visited[current]) {
                continue;
            }
            visited[current] = true;

            for (Node node : adjList[current]) {
                int next = node.next;
                int cost = node.cost;

                if (curTotal + cost <= c) {
                    queue.add(new int[]{next, Math.max(resultCost, cost), curTotal+cost});
                }
            }
        }
    }
}
