import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static Integer[][] dp;
    static Node[] nodes;
    static class Node {
        int w;
        int v;

        public Node(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new Integer[n][k+1];
        nodes = new Node[n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(a, b);
        }

        int result = dfs(0, 0);
        System.out.println(result);
    }

    private static int dfs(int choose, int weight) {
        if (choose >= n) {
            return 0;
        }

        if (dp[choose][weight] != null) {
            return dp[choose][weight];
        }

        int max = 0;

        max = Math.max(max, dfs(choose+1, weight));
        if (weight + nodes[choose].w <= k) {
            max = Math.max(max, nodes[choose].v + dfs(choose+1, weight+nodes[choose].w));
        }

        dp[choose][weight] = max;

        return max;
    }
}