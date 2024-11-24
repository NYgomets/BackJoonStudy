import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int d;
    static int c;
    static int[] shortest;
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
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int l=0; l<t; l++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            shortest = new int[n+1];
            for (int i=1; i<=n; i++) {
                if (i == c) {
                    shortest[i] = 0;
                } else {
                    shortest[i] = Integer.MAX_VALUE;
                }
            }
            visitedArr = new boolean[n+1];
            adjList = new ArrayList[n+1];
            for (int i=1; i<=n; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i=0; i<d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                adjList[b].add(new Node(a, c));
            }

            int result  = dikstra(c);
            int max = 0;
            for (int i=1; i<=n; i++) {
                if (max < shortest[i] && shortest[i] != Integer.MAX_VALUE) {
                    max = shortest[i];
                }
            }

            System.out.println(result + " " + max);
        }
    }

    private static int dikstra(int start) {
        Queue<Node> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.getWeight(), o2.getWeight())));
        queue.add(new Node(start, 0));
        int count = 1;

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

                if (shortest[next] > shortest[current] + weight) {
                    if (shortest[next] == Integer.MAX_VALUE) {
                        count++;
                    }
                    shortest[next] = shortest[current] + weight;
                    queue.add(new Node(next, shortest[next]));
                }
            }
        }
        return count;
    }
}
