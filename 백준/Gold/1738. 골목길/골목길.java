import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] path;
    static long[] shortest;
    static int[][] edgeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        shortest = new long[n+1];
        Arrays.fill(shortest, Integer.MIN_VALUE);
        shortest[1] = 0;

        edgeList = new int[m+1][3];
        for (int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edgeList[i][0] = a;
            edgeList[i][1] = b;
            edgeList[i][2] = c;
        }

        path = new int[n+1];
        path[1] = -1;
        for (int i=0; i<n-1; i++) {
            bellman();
        }

        if (shortest[n] == Integer.MIN_VALUE) {
            System.out.println(-1);
            return;
        }

        boolean minus = false;
        for (int i=1; i<=m; i++) {
            if (isCycle(edgeList[i][0], edgeList[i][1], edgeList[i][2]) && isCycleOnPath(edgeList[i][1])) {
                minus = true;
                break;
            }
        }


        if (minus) {
            System.out.println(-1);
        } else {
            printPath(n);
        }
    }

    private static boolean isCycleOnPath(int to) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(to);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (visited[current]) {
                continue;
            }
            visited[current] = true;

            for (int[] edge : edgeList) {
                int first = edge[0];
                int second = edge[1];

                if (first == current && !visited[second]) {
                    queue.add(second);
                }
            }
        }
        return visited[n];
    }

    private static boolean isCycle(int from, int to, int weight) {
        return shortest[to] < shortest[from] + weight;
    }

    private static void printPath(int start) {
        if (start == -1) {
            return;
        }

        printPath(path[start]);
        System.out.print(start + " ");
    }

    private static void bellman() {
        for (int i=1; i<=m; i++) {
            if (shortest[edgeList[i][0]] != Integer.MIN_VALUE && shortest[edgeList[i][1]] < shortest[edgeList[i][0]] + edgeList[i][2]) {
                shortest[edgeList[i][1]] = shortest[edgeList[i][0]]+edgeList[i][2];
                path[edgeList[i][1]] = edgeList[i][0];
            }
        }
    }
}
