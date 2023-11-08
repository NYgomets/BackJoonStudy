import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int node, line, start;
    static int[][] graph;
    static int[] marked;

    static void dfs(int start, int[] marked) {
        if (marked[start] == 1) {
            return;
        }

        marked[start] = 1;
        System.out.print(start + " ");

        for (int i = 1; i < node+1; i++) {
            if (marked[i] == 0 && graph[start][i] == 1) {
                dfs(i, marked);
            }
        }

    }

    static void bfs(int start, int[] marked) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        marked[start] = 1;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            System.out.print(poll + " ");
            for (int i = 1; i < node + 1; i++) {
                if (marked[i] == 0 && graph[poll][i] == 1) {
                    queue.add(i);
                    marked[i] = 1;
                }
            }

        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new int[node+1][node+1];
        marked = new int[node+1];

        for (int i=0; i<line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            //인접 행렬 설정
            graph[a][b] = graph[b][a] = 1;
        }

        dfs(start, marked);
        System.out.println();
        marked = new int[node+1];
        bfs(start, marked);
    }
}