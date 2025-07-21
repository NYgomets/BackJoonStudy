import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int computer;
    static List<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        computer = Integer.parseInt(br.readLine());
        list = new ArrayList[computer+1];
        for (int i=1; i<=computer; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[computer+1];

        int m = Integer.parseInt(br.readLine());
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        int result = dfs(1);
        System.out.println(result);
    }

    private static int dfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (Integer next : list[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    count++;
                    queue.add(next);
                }
            }
        }

        return count;
    }
}
