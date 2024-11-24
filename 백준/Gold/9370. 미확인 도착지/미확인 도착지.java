import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int t;
    static int s;
    static int g;
    static int h;
    static int z;
    static List<Integer> result;
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
        int p = Integer.parseInt(br.readLine());
        for (int l=0; l<p; l++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 노드의 수
            m = Integer.parseInt(st.nextToken()); // 간선의 수
            t = Integer.parseInt(st.nextToken()); // 후보의 수

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()); // 출발지
            g = Integer.parseInt(st.nextToken()); // 체크 노드1
            h = Integer.parseInt(st.nextToken()); // 체크 노드2

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

            result = new ArrayList<>();
            for (int i=0; i<t; i++) {
                z = Integer.parseInt(br.readLine());
                dikstra(s);
                int check = shortest[z];
                dikstra(s);
                int firstA = shortest[g];
                int firstB = shortest[h];
                dikstra(g);
                int secondA = shortest[h];
                int secondB = shortest[z];
                dikstra(h);
                int thirdA = shortest[z];
                int thirdB = shortest[g];

                if (check == firstA+secondA+thirdA || check == firstB+secondB+thirdB) {
                    result.add(z);
                }
            }

            Collections.sort(result);
            for (int r : result) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }

    private static void dikstra(int start) {
        shortest = new int[n+1];
        Arrays.fill(shortest, Integer.MAX_VALUE);
        shortest[start] = 0;
        visitedArr = new boolean[n+1];
        Queue<Node> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.getWeight(), o2.getWeight())));
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

                if (shortest[next] > shortest[current] + weight) {
                    shortest[next] = shortest[current] + weight;
                    queue.offer(new Node(next, shortest[next]));
                }
            }
        }
    }
}
