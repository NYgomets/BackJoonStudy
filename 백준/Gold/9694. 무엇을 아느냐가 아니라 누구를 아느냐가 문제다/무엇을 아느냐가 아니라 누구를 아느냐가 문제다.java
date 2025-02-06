import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static List<Node>[] adjList;
    static long[] shortest;
    static boolean[] visited;
    static int[] parent;
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
        int t = Integer.parseInt(br.readLine());
        for (int q=1; q<=t; q++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            shortest = new long[m];
            Arrays.fill(shortest, Integer.MAX_VALUE);
            shortest[0] = 0;
            visited = new boolean[m];
            adjList = new ArrayList[m];
            for (int i=0; i<m; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                adjList[a].add(new Node(b, c));
                adjList[b].add(new Node(a, c));
            }

            parent = new int[m];
            distra(0);
            if (shortest[m-1] == Integer.MAX_VALUE) {
                sb.append("Case #").append(q).append(": -1");
            } else {
                sb.append("Case #").append(q).append(": ").append(findParent(m-1));
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static String findParent(int start) {
        if (start == -1) {
            return "";
        }

        return findParent(parent[start]) + start + " ";
    }

    private static void distra(int start) {
        Queue<Node> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.weight, o2.weight)));
        queue.add(new Node(start, 0));
        parent[start] = -1;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int current = poll.end;

            if (visited[current]) {
                continue;
            }
            visited[current] = true;

            for (Node node : adjList[current]) {
                int next = node.end;
                int weight = node.weight;

                if (shortest[next] > shortest[current]+weight) {
                    shortest[next] = shortest[current]+weight;
                    parent[next] = current;
                    queue.add(new Node(next, (int) shortest[next]));
                }
            }
        }
    }
}
