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
        int end;
        long weight;

        public Node(int end, long weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        shortest = new long[n+1];
        visited = new boolean[n+1];
        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
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
        shortest[start] = Integer.MAX_VALUE;

        dikstra(start);
        System.out.println(shortest[end]);
    }

    private static void dikstra(int start) {
        Queue<Node> queue = new PriorityQueue<>(((o1, o2) -> Long.compare(o2.weight, o1.weight)));
        queue.add(new Node(start, Integer.MAX_VALUE));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int current = poll.end;
            long currentWeight = poll.weight;

            if (visited[current]) {
                continue;
            }
            visited[current] = true;

            for (Node node : adjList[current]) {
                int next = node.end;
                long nextWeight = node.weight;

                long possible = Math.min(currentWeight, nextWeight);

                if (shortest[next] < possible) {
                    shortest[next] = possible;
                    queue.add(new Node(next, shortest[next]));
                }
            }
        }
    }
}
