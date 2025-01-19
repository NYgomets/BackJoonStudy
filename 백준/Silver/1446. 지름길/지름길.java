import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int d;
    static List<Node>[] adjList;
    static int[] shortest;
    static boolean[] visited;
    static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[d+1];
        for (int i=0; i<=d; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (end <= d) {
                adjList[start].add(new Node(end, weight));
            }
        }

        for (int i=0; i<d; i++) {
            adjList[i].add(new Node(i+1, 1));
        }

        visited = new boolean[d+1];
        shortest = new int[d+1];
        Arrays.fill(shortest, Integer.MAX_VALUE);
        shortest[0]= 0;
        dikstra(0);
        System.out.println(shortest[d]);
    }

    private static void dikstra(int start) {
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int current = poll.end;

            if (visited[current]) {
                continue;
            }
            visited[current] = true;

            for (Node nodes : adjList[current]) {
                int next = nodes.end;
                int weight = nodes.weight;
                if (shortest[next] > shortest[current]+weight) {
                    shortest[next] = shortest[current]+weight;
                    queue.offer(new Node(next, shortest[next]));
                }
            }
        }
    }
}