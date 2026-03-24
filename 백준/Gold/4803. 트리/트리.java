import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] adjList;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int check = 0;

        while (true) {
            check++;
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) break;

            adjList = new ArrayList[a + 1];
            for  (int i = 1; i <= a; i++) {
                adjList[i] = new ArrayList<>();
            }
            visited = new boolean[a + 1];

            for (int i=0; i<b; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                adjList[x].add(y);
                adjList[y].add(x);
            }

            int t = 0;
            List<Integer> contain = new ArrayList<>();
            for (int i=1; i<=a; i++) {
                if (!visited[i]) {
                    if (dfs(i, 0)) {
                        t++;
                    }
                }
            }

            if (t == 1) {
                sb.append("Case ").append(check).append(": There is one tree.").append("\n");
            } else if (t > 1) {
                sb.append("Case ").append(check).append(": A forest of ").append(t).append(" trees.").append("\n");
            } else {
                sb.append("Case ").append(check).append(": No trees.").append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static boolean dfs(int start, int dev) {
        boolean tree = true;
        visited[start] = true;

        for (int next : adjList[start]) {
            if (!visited[next]) {
                if (!dfs(next, start)) {
                    return false;
                }
            } else if (next != dev) {
                return false;
            }
        }

        return tree;
    }
}