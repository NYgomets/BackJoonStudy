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
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n+1];
        for (int i =1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new Node(b, c));
        }

        int[] check = new int[n+1];
        for (int i=1; i<=n; i++) {
            dikstra(i);
            check[i] = shortest[x];
            dikstra(x);
            check[i] = check[i] + shortest[i];
        }

        int result=0;
        for (int i=1; i<=n; i++) {
            if (result < check[i]) {
                result = check[i];
            }
        }

        System.out.println(result);

    }

    private static void dikstra(int person) {
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        visitedArr = new boolean[n+1];
        shortest = new int[n+1];
        for (int i=1; i<=n; i++) {
            if (i == person) {
                shortest[i] = 0;
            } else {
                shortest[i] = Integer.MAX_VALUE;
            }
        }
        queue.add(new Node(person, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int current = poll.getEnd();

            if (visitedArr[current]) {
                continue;
            }
            visitedArr[current] = true;

            for (Node no : adjList[current]) {
                int next = no.getEnd();
                int weight = no.weight;
                if (shortest[next] > shortest[current] + weight) {
                    shortest[next] = shortest[current] + weight;
                    queue.offer(new Node(next, shortest[next]));
                }
            }
        }
    }
}