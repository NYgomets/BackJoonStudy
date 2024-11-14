import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] friends;
    static int m;
    static int[][] shortest;
    static boolean[] visitedArr;
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
        n = Integer.parseInt(br.readLine());
        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        friends = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=3; i++) {
            friends[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }

        shortest = new int[4][n+1];
        for (int i=1; i<=3; i++) {
            visitedArr = new boolean[n+1];
            dikstra(i, friends[i]);
        }

        int result = 0;
        int dup = 0;
        for (int i=1; i<=n; i++) {
            int min = Math.min(shortest[1][i], Math.min(shortest[2][i], shortest[3][i]));
            
            if (min > dup) {
                dup = min;
                result = i;
            }
        }

        System.out.println(result);
    }

    private static void dikstra(int friends, int start) {
        Arrays.fill(shortest[friends], Integer.MAX_VALUE);
        shortest[friends][start] = 0;
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

                if (shortest[friends][next] > shortest[friends][current] + weight) {
                    shortest[friends][next] = shortest[friends][current] + weight;
                    queue.offer(new Node(next, shortest[friends][next]));
                }
            }
        }
    }
}