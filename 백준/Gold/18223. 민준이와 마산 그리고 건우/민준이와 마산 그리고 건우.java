import java.io.*;
import java.util.*;

public class Main {
    static int v; // 노드 수
    static int e; // 간선 수
    static int p; // 건우 위치
    static boolean[] visitedArr;
    static long[] shortest;
    static List<Node>[] adjList;
    static class Node {
        int end;
        long weight;

        public Node(int end, long weight) {
            this.end = end;
            this.weight = weight;
        }

        public int getEnd() {
            return end;
        }

        public long getWeight() {
            return weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[v+1];
        for (int i=1; i<=v; i++) {
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

        dikstra(1);
        long first = shortest[p];
        long goal = shortest[v];
        dikstra(p);
        long second = shortest[v];
        
        if (first+second == goal) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }
    }

    private static void dikstra(int start) {
        visitedArr = new boolean[v+1];
        shortest = new long[v+1];
        Arrays.fill(shortest, Integer.MAX_VALUE);
        shortest[start] = 0;
        Queue<Node> queue = new PriorityQueue<>(((o1, o2) -> Long.compare(o1.getWeight(), o2.getWeight())));
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
                long weight = node.getWeight();

                if (shortest[next] > shortest[current]+weight) {
                    shortest[next] = shortest[current]+weight;
                    queue.add(new Node(next, shortest[next]));
                }
            }
        }
    }
}
