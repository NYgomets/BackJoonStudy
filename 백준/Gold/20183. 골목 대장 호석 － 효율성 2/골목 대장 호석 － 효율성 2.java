import java.io.*;
import java.util.*;

public class Main {
    static int n, m, a, b;
    static long c;
    static List<Node>[] adjList;
    static long[] shortest;

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
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Long.parseLong(st.nextToken());

        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adjList[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());
            adjList[start].add(new Node(end, weight));
            adjList[end].add(new Node(start, weight));
        }

        shortest = new long[n + 1];
        Arrays.fill(shortest, Long.MAX_VALUE);
        shortest[a] = 0;

        long result = dikstra();
        System.out.println(result == Long.MAX_VALUE ? -1 : result);
    }

    private static long dikstra() {
        Queue<long[]> queue = new PriorityQueue<>((o1, o2) -> Long.compare(o1[2], o2[2]));
        queue.add(new long[]{a, 0, 0});

        while (!queue.isEmpty()) {
            long[] poll = queue.poll();
            int current = (int) poll[0];
            long currentCost = poll[1];
            long currentMax = poll[2];

            if (current == b) return currentMax;

            if (currentMax > shortest[current]) continue;

            for (Node nodes : adjList[current]) {
                long nextCost = currentCost + nodes.weight;
                long nextMax = Math.max(currentMax, nodes.weight);

                if (nextCost <= c && nextMax < shortest[nodes.end]) {
                    shortest[nodes.end] = nextMax;
                    queue.add(new long[]{nodes.end, nextCost, nextMax});
                }
            }
        }

        return Long.MAX_VALUE;
    }
}
