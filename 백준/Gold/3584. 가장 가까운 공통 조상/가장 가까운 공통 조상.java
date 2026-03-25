import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] adjList;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int z=0; z<t; z++) {
            int n = Integer.parseInt(br.readLine());

            visited = new boolean[n+1];
            adjList = new ArrayList[n+1];
            for (int i=1; i<=n; i++) {
                adjList[i] = new ArrayList<>();
            }

            boolean[] hasParent = new boolean[n+1];
            for (int l=1; l<n; l++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                adjList[x].add(y);
                hasParent[y] = true;
            }

            int root = 0;
            for (int i=1; i<=n; i++) {
                if (!hasParent[i]) {
                    root = i;
                }
            }

            st =  new StringTokenizer(br.readLine());
            int check1 = Integer.parseInt(st.nextToken());
            int check2 = Integer.parseInt(st.nextToken());

            int[] dfs = dfs(root, check1, check2, 0);
            if (dfs[1] == 2) {
                sb.append(dfs[0]).append("\n");
            }

        }
        System.out.println(sb.toString());
    }

    private static int[] dfs(int current, int check1, int check2, int depth) {
        visited[current] = true;
        int start = 0;
        int find = 0;
        int sum = 0;
        if (current==check1 || current==check2) {
            find = 1;
            sum = depth;
        }

        for (int next : adjList[current]) {
            if (!visited[next]) {
                int[] dfs = dfs(next, check1, check2, depth + 1);
                if (start == 0) {
                    start = dfs[0];
                }
                find += dfs[1];
                sum += dfs[2];
            }
        }

        if (find == 2 && start == 0) {
            start = current;
        }
        return new  int[]{start, find, sum};
    }
}