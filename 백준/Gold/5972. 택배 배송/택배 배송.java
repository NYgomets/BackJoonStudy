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
        int cow;

        public Node(int end, int cow) {
            this.end = end;
            this.cow = cow;
        }

        public int getEnd() {
            return end;
        }

        public int getCow() {
            return cow;
        }
    }
    static int INF = 50000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visitedArr = new boolean[n+1];
        shortestArr = new int[n+1];
        for (int i=1; i<=n; i++) {
            if (i==1) {
                shortestArr[i] = 0;
            } else {
                shortestArr[i] = INF;
            }
        }
        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            adjList[A].add(new Node(B, C));
            adjList[B].add(new Node(A, C));
        }

        dikstra(1);

        System.out.println(shortestArr[n]);
    }

    private static void dikstra(int start) {
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getCow() - o2.getCow();
            }
        });
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int current = poll.getEnd();

            if (visitedArr[current]) {
                continue;
            }
            visitedArr[current] = true;

            for (Node node : adjList[current]) {
                int next = node.getEnd();
                int cow = node.getCow();

                if (shortestArr[next] > shortestArr[current] + cow) {
                    shortestArr[next] = shortestArr[current] + cow;
                    queue.offer(new Node(next, shortestArr[next]));
                }
            }

        }
    }
}