import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int v;
    static int e;
    static int a;
    static int b;
    static int[] person;
    static List<Node>[] adjList;
    static boolean[] visited;
    static long[] shortest;
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
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        person = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }
        adjList = new ArrayList[v+1];
        for (int i=1; i<=v; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());
            adjList[first].add(new Node(second, third));
            adjList[second].add(new Node(first, third));
        }

        int result = 0;
        for (int q=1; q<person.length; q++) {
            int position = person[q];
            visited = new boolean[v+1];

            dikstra(position);

            int first = 0;
            int second = 0;
            if (shortest[a] == Integer.MAX_VALUE) {
                first = -1;
            } else {
                first = (int) shortest[a];
            }

            if (shortest[b] == Integer.MAX_VALUE) {
                second = -1;
            } else {
                second = (int) shortest[b];
            }
            result += (first+second);
        }

        System.out.println(result);
    }

    private static void dikstra(int start) {
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.weight-o2.weight);
        shortest = new long[v+1];
        Arrays.fill(shortest, Integer.MAX_VALUE);
        shortest[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int current = poll.end;

            if(visited[current]) {
                continue;
            }
            visited[current] = true;

            for (Node node : adjList[current]) {
                int next = node.end;
                int weight = node.weight;

                if (shortest[next]>shortest[current]+weight) {
                    shortest[next] = shortest[current]+weight;
                    queue.add(new Node(next, (int) shortest[next]));
                }
            }
        }
    }
}
