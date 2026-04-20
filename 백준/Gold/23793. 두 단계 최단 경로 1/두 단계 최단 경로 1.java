import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] shortest;
    static boolean[] visited;
    static List<Node>[] adjList;
    static class Node {
        int next;
        int cost;
        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        shortest = new int[n+1];
        visited = new boolean[n+1];
        adjList = new List[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new LinkedList<>();
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
        int mid = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int first;
        int second;

        dikstra(start);
        int check1 = shortest[mid];
        dikstra(mid);
        int check2 = shortest[end];
        if (check1 == Integer.MAX_VALUE || check2 == Integer.MAX_VALUE) {
            first = -1;
        } else {
            first = check1 + check2;
        }

        noDikstra(start, mid);
        if (shortest[end] == Integer.MAX_VALUE) {
            second = -1;
        } else {
            second = shortest[end];
        }

        System.out.println(first + " " + second);
    }

    private static void noDikstra(int start, int mid) {
        Arrays.fill(shortest, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        shortest[start] = 0;
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int current = poll[0];

            if (visited[current]) {
                continue;
            }
            visited[current] = true;

            for (Node node : adjList[current]) {
                int next = node.next;
                int cost = node.cost;

                if (next == mid) {
                    continue;
                }

                if (shortest[next] > shortest[current] + cost) {
                    shortest[next] = shortest[current] + cost;
                    queue.add(new int[]{next, shortest[next]});
                }
            }
        }
    }

    private static void dikstra(int start) {
        Arrays.fill(shortest, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        shortest[start] = 0;
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int current = poll[0];

            if (visited[current]) {
                continue;
            }
            visited[current] = true;

            for (Node node : adjList[current]) {
                int next = node.next;
                int cost = node.cost;

                if (shortest[next] > shortest[current] + cost) {
                    shortest[next] = shortest[current] + cost;
                    queue.add(new int[]{next, shortest[next]});
                }
            }
        }
    }
}