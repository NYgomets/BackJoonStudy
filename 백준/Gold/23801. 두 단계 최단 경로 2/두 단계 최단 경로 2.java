import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static long[] shortest;
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

        shortest = new long[n+1];
        visited = new boolean[n+1];
        adjList = new List[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new LinkedList<>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dikstra(start);
        long[] fromStart = shortest.clone();
        dikstra(end);
        long[] fromEnd = shortest.clone();

        long result = Long.MAX_VALUE;
        int check = Integer.parseInt(br.readLine());
        StringTokenizer sto = new StringTokenizer(br.readLine());
        for (int i=0; i<check; i++) {
            int mid = Integer.parseInt(sto.nextToken());
            long check1 = fromStart[mid];
            long check2 = fromEnd[mid];

            if (check1 == Long.MAX_VALUE || check2 == Long.MAX_VALUE) {
                continue;
            }

            result = Math.min(result, check1 + check2);
        }

        if (result == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static void dikstra(int start) {
        Arrays.fill(shortest, Long.MAX_VALUE);
        Arrays.fill(visited, false);
        shortest[start] = 0;

        Queue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        queue.add(new long[]{start, 0});

        while (!queue.isEmpty()) {
            long[] poll = queue.poll();
            int current = (int) poll[0];

            if (visited[current]) {
                continue;
            }
            visited[current] = true;

            for (Node node : adjList[current]) {
                int next = node.next;
                int cost = node.cost;

                if (shortest[next] > shortest[current] + cost) {
                    shortest[next] = shortest[current] + cost;
                    queue.add(new long[]{next, shortest[next]});
                }
            }
        }
    }
}