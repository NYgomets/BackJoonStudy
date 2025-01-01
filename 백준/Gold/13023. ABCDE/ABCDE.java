import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static List<Integer>[] friends;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        friends = new ArrayList[n];
        for (int i=0; i<n; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }

        for (int i=0; i<n; i++) {
            visited = new boolean[n];
            int find = bfs(i, 0);

            if (find > 0) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    private static int bfs(int start, int depth) {
        if (depth == 4) {
            return 1;
        }

        int find = 0;
        visited[start] = true;
        for (int next : friends[start]) {
            if (!visited[next]) {
                find += bfs(next, depth+1);

            }
        }
        visited[start] = false;

        return find;
    }
}