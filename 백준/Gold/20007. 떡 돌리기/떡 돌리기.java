import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int x;
    static int y;
    static boolean[] visited;
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n];
        for (int i=0; i<n; i++) {
            adjList[i] = new ArrayList<>();
        }
        visited = new boolean[n];
        shortest = new int[n];
        for (int i=0; i<n; i++) {
            if (i == y) {
                shortest[i] = 0;
            } else {
                shortest[i] = Integer.MAX_VALUE;
            }
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }

        dikstra(y);
        for (int i=0; i<n; i++) {
            if (shortest[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
                return;
            }
        }

        Arrays.sort(shortest);
        int day = 0;
        int current = 0;
        boolean end = false;
        for (int i=1; i<n; i++) {
            current += shortest[i]*2;

            if (current <= x) {
                end = true;
                continue;
            } else {
                day++;
                current = 0;
                i--;
                end = false;
            }
        }

        if (end) {
            day++;
        }

        System.out.println(day);
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

                if ((shortest[current] + cost) * 2 <= x) {
                    if (shortest[next] > shortest[current] + cost) {
                        shortest[next] = shortest[current] + cost;
                        queue.add(new int[]{next, shortest[next]});
                    }
                }
            }
        }
    }
}