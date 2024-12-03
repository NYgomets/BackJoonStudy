import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] arr;
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

        public int getEnd() {
            return end;
        }

        public long getWeight() {
            return weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        shortest = new long[n+1];
        Arrays.fill(shortest, Integer.MAX_VALUE);
        shortest[1] = 0;
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

        arr = new int[n+1];
        dikstra(1);
        System.out.println(n-1);
        for (int i=2; i<=n; i++) {
            System.out.println(arr[i] + " "+ i);
        }
    }

    private static void dikstra(int start) {
        Queue<Node> queue = new PriorityQueue<>(((o1, o2) -> Long.compare(o1.getWeight(), o2.getWeight())));
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int current = poll.getEnd();

            if (visited[current]) {
                continue;
            }
            visited[current] = true;

            for (Node node : adjList[current]) {
                int next = node.getEnd();
                long weight = node.getWeight();

                if (shortest[next] > shortest[current] + weight) {
                    arr[next] = current;
                    shortest[next] = shortest[current]+weight;
                    queue.add(new Node(next, shortest[next]));
                }
            }
        }
    }
}
