import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        visited= new boolean[100001];

        int result = bfs(n, k);
        System.out.println(result);
    }

    private static int bfs(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int current = poll[0];
            int time = poll[1];

            if (current == end) {
                return time;
            }

            int[] move = {-1, 1, current};
            for (int i=0; i<3; i++) {
                int next = current+move[i];

                if ((0<=next && next<=100000) && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, time+1});
                }
            }
        }

        return 0;
    }
}