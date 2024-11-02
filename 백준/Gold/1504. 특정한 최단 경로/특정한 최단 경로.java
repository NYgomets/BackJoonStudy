import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int getNode() {
            return node;
        }

        public int getWeight() {
            return weight;
        }
    }

    static List<Node>[] adjList;
    static boolean[] visitedArr;
    static int[] shortestArr;
    static int n;
    static int INF = 200000*1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        /**
         * 오버플로우 조심
         */
        int checkFirst = dikstra(1, u) + dikstra(u, v) + dikstra(v, n);
        int checkSecond = dikstra(1, v) + dikstra(v, u) + dikstra(u, n);

        if (checkFirst >= INF && checkSecond >= INF) {
            System.out.println("-1");
        } else System.out.println(Math.min(checkFirst, checkSecond));

    }

    private static int dikstra(int start, int end) {
        visitedArr = new boolean[n+1];
        Arrays.fill(visitedArr, false);
        shortestArr = new int[n+1];
        Arrays.fill(shortestArr, INF);
        shortestArr[start] = 0;
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int current = poll.getNode();

            if (!visitedArr[current]) {
                visitedArr[current] = true;
            }

            for (Node node : adjList[current]) {
                int next = node.getNode();
                int w = node.getWeight();
                if (!visitedArr[end] && shortestArr[next] > shortestArr[current]+w) {
                    shortestArr[next] = shortestArr[current]+w;
                    queue.offer(new Node(next, shortestArr[next]));
                }
            }
        }
        return shortestArr[end];
    }
}