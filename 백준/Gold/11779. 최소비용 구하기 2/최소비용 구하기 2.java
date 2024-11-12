import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static List<Node>[] adjList;
    static class Node {
        int city;
        int cost;

        public Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        public int getCity() {
            return city;
        }

        public int getCost() {
            return cost;
        }
    }
    static long[] shortestArr;
    static boolean[] visitedArr;
    static int[] parent;
    static int checkCity = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        shortestArr = new long[n+1];

        visitedArr = new boolean[n+1];
        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new Node(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        for (int i=1; i<=n; i++) {
            if (i==start) {
                shortestArr[i] = 0;
            } else {
                shortestArr[i] = Integer.MAX_VALUE;
            }
        }

        parent = new int[n+1];
        dikstra(start);
        System.out.println(shortestArr[end]);
        printParent(end);
        System.out.println(checkCity);
        System.out.println(sb);
    }

    private static void printParent(int end) {
        if (end == -1) {
            return;
        }
        printParent(parent[end]);
        checkCity++;
        sb.append(end).append(" ");
    }

    private static void dikstra(int start) {
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getCost() - o2.getCost();
            }
        });
        queue.offer(new Node(start, 0));
        parent[start] = -1;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int current = poll.getCity();

            if (visitedArr[current]) {
                continue;
            }
            visitedArr[current] = true;

            for (Node node : adjList[current]) {
                int next = node.getCity();
                int cost = node.getCost();
                if (shortestArr[next] > shortestArr[current] + cost) {
                    shortestArr[next] = shortestArr[current] + cost;
                    parent[next] = current;
                    queue.offer(new Node(next, Integer.parseInt(String.valueOf(shortestArr[next]))));
                }
            }
        }
    }
}