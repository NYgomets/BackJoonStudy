import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean[] visitedArr;
    static int[] shortest;
    static List<Node>[] adjList;
    static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int getEnd() {
            return end;
        }

        public int getWeight() {
            return weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visitedArr = new boolean[n+1];
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
        shortest = new int[n+1];
        for (int i=1; i<=n; i++) {
            if (i==start) {
                shortest[i] = 0;
            } else {
                shortest[i] = Integer.MAX_VALUE;
            }
        }

        dikstra(start);
        System.out.println(shortest[end]);
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
            Node poll = queue.poll();
            int current = poll.getEnd();

            if (visitedArr[current]) {
                continue;
            }
            visitedArr[current] = true;

            for (Node node : adjList[current]) {
                int next = node.getEnd();
                int weight = node.getWeight();

                if (shortest[next] > shortest[current]+weight) {
                    shortest[next] = shortest[current]+weight;
                    queue.offer(new Node(next, shortest[next]));
                }
            }
        }
    }
}