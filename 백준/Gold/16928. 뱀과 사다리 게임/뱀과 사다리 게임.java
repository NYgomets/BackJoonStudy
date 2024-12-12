import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean[] visited;
    static List<Node>[] adjList;
    static class Node {
        int end;

        public Node(int end) {
            this.end = end;
        }
    }
    static int result = Integer.MAX_VALUE;
    static int[] dice = {1, 2, 3, 4, 5, 6};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[101];
        for (int i=1; i<=100; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i=1; i<=n+m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(new Node(b));
        }

        visited = new boolean[101];
        bfs(1);
        System.out.println(result);
    }

    private static void bfs(int start) {
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        queue.add(new int[]{1, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int current = poll[0];
            int count = poll[1];

            if (visited[current]) {
                continue;
            }
            visited[current] = true;

            if (current == 100) {
                result = Math.min(result, count);
                continue;
            }

            for (int i=0; i<6; i++) {
                int next = current+dice[i];

                if (next > 100) {
                    continue;
                }

                if (!adjList[next].isEmpty()) {
                    for (Node node : adjList[next]) {
                        queue.add(new int[]{node.end, count+1});
                    }
                } else {
                    queue.add(new int[]{next, count+1});
                }
            }
        }
    }
}
