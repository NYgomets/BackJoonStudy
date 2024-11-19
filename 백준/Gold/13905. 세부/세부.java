import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean[] visitedArr;
    static int[] shortestArr;
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
        shortestArr = new int[n+1];
        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }

        for (int i=1; i<=n; i++) {
            if (i == start) {
                shortestArr[i] = Integer.MAX_VALUE;
            } else {
                shortestArr[i] = 0;
            }
        }
        dikstra(start);

        System.out.println(shortestArr[end]);
    }

    private static void dikstra(int start) {
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.getWeight() - o1.getWeight();
            }
        });
        queue.add(new Node(start, Integer.MAX_VALUE));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int current = poll.getEnd();
            int passWeight = poll.getWeight();

            if (visitedArr[current]) {
                continue;
            }
            visitedArr[current] = true;

            for (Node node : adjList[current]) {
                int next = node.getEnd();
                int weight = node.getWeight();

                int check = Math.min(passWeight, weight);

                if (shortestArr[next] < check) {
                    shortestArr[next] = check;
                    queue.add(new Node(next, shortestArr[next]));
                }
            }
        }
    }
}
