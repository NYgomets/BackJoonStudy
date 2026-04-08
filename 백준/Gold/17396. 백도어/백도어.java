import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] sight;
    static boolean[] visited;
    static long[] shortest;
    static List<Node>[] adjList;

    static class Node {
        int next;
        long time;

        public Node(int next, long time) {
            this.next = next;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        sight = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sight[i] = Integer.parseInt(st.nextToken());
        }

        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }

        shortest = new long[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                shortest[i] = 0;
            } else {
                shortest[i] = Long.MAX_VALUE;
            }
        }

        dijkstra(0);

        if (shortest[n - 1] == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(shortest[n - 1]);
        }
    }

    private static void dijkstra(int start) {
        Queue<long[]> queue = new PriorityQueue<>((o1, o2) -> Long.compare(o1[1], o2[1]));
        queue.add(new long[]{start, 0});

        while (!queue.isEmpty()) {
            long[] poll = queue.poll();
            int current = (int) poll[0];

            if (visited[current]) continue;
            visited[current] = true;

            for (Node node : adjList[current]) {
                int next = node.next;
                long time = node.time;

                if (next != n - 1 && sight[next] == 1) continue;

                if (shortest[next] > shortest[current] + time) {
                    shortest[next] = shortest[current] + time;
                    queue.add(new long[]{next, shortest[next]});
                }
            }
        }
    }
}
