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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        visitedArr = new boolean[v+1];
        shortestArr = new int[v+1];
        for (int i=1; i<=v; i++) {
            if (i==start) {
                shortestArr[i] = 0;
            } else {
                shortestArr[i] = Integer.MAX_VALUE;
            }
        }

        adjList = new ArrayList[v+1];
        for (int i=1; i<=v; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList[first].add(new Node(second, w));
        }

        dikstra(start);

        for (int i=1; i<=v; i++) {
            if (shortestArr[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(shortestArr[i]);
            }
        }
    }

    private static void dikstra(int start) {
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int current = node.getNode();

            if (visitedArr[current]) {
                continue;
            }
            visitedArr[current] = true;

            for (Node no : adjList[current]) {
                int next = no.getNode();
                int weight = no.getWeight();

                if (shortestArr[next] > shortestArr[current]+weight) {
                    shortestArr[next] = shortestArr[current]+weight;
                    queue.offer(new Node(next, shortestArr[next]));
                }
            }
        }
    }
}