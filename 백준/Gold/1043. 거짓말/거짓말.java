import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int truly;
    static boolean[] trulyArr;
    static List<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        truly = Integer.parseInt(st.nextToken());
        trulyArr = new boolean[n+1];
        for (int i=0; i<truly; i++) {
            int a = Integer.parseInt(st.nextToken());
            trulyArr[a] = true;
        }

        list = new ArrayList[m+1];
        for (int i=1; i<=m; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());
            int person = Integer.parseInt(st.nextToken());

            for (int j=0; j<person; j++) {
                int a = Integer.parseInt(st.nextToken());
                list[i].add(a);
            }
        }

        visited = new boolean[n+1];
        for (int i=1; i<=n; i++) {
            if (!visited[i] && trulyArr[i]) {
                dfs(i);
            }
        }

        int result = 0;
        for (int i=1; i<=m; i++) {
            boolean state = false;
            for (int p : list[i]) {
                if (trulyArr[p]) {
                    state = true;
                }
            }
            if (!state) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static void dfs(int i) {
        visited[i] = true;

        for (int j=1; j<=m; j++) {
            if (list[j].contains(i)) {
                for (int next : list[j]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        trulyArr[next] = true;
                        dfs(next);
                    }
                }
            }
        }
    }
}
