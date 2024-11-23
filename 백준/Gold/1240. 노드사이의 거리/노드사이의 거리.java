import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }

        for (int i=0; i<m ;i++) {
            visitedArr = new boolean[n+1];
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = bfs(a, b);
            System.out.println(result);
        }
    }

    private static int bfs(int start, int end) {
        Queue<Node> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.getWeight(), o2.getWeight())));
        visitedArr[start] = true;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int current = poll.getEnd();
            int prevWeight = poll.getWeight();

            if (current == end) {
                return prevWeight;
            }

            for (Node node : adjList[current]) {
                int next = node.getEnd();
                int weight = node.getWeight();

                if (!visitedArr[next]) {
                    visitedArr[next] = true;
                    queue.offer(new Node(next, prevWeight+weight));
                }
            }
        }

        return -1;
    }
}
