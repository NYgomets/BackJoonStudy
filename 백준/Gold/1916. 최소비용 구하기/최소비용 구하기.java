import java.io.*;
import java.util.*;

public class Main {
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
    static List<Node>[] adjList;
    static int[] shortest;
    static boolean[] visitedArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;

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
        visitedArr = new boolean[n+1];
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
            int current = poll.end;

            if (visitedArr[current]) {
                continue;
            }
            visitedArr[current] = true;

            for (Node nodes : adjList[current]) {
                int next = nodes.getEnd();
                int weight = nodes.getWeight();
                if (shortest[next] > shortest[current] + weight) {
                    shortest[next] = shortest[current] + weight;
                    queue.offer(new Node(next, shortest[next]));
                }
            }
        }
    }
}