import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        arr = new int[n][n];
        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs( 0, 0);
        System.out.println(min);
    }

    private static void dfs(int idx, int count) {
        if (count == n/2) {
            calculating();
            return;
        }

        for (int i=idx; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i+1, count+1);
                visited[i] = false;
            }
        }
    }

    private static void calculating() {
        int first = 0;
        int second = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i] && visited[j]) {
                    first += arr[i][j];
                } else if (!visited[i] && !visited[j]) {
                    second += arr[i][j];
                }
            }
        }

        min = Math.min(min, Math.abs(first-second));
    }
}
