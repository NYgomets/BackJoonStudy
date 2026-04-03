import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static Node[] nodes;
    static Integer[][] dp;
    static class Node {
        int left;
        int right;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new Integer[n][n];
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(a, b);
        }

        int result = dfs(0, n-1);
        System.out.println(result);
    }

    private static int dfs(int start, int end) {
        if (dp[start][end] != null) {
            return dp[start][end];
        }

        int min = Integer.MAX_VALUE;

        if (end-start == 0) {
            return dp[start][end] = 0;
        }

        if (end-start == 1) {
            return dp[start][end] = nodes[start].left*nodes[start].right*nodes[end].right;
        }

        if (end-start > 1) {
            for (int i=start; i<end; i++) {
                int left = dfs(start, i);
                int right = dfs(i+1, end);
                int cost = nodes[start].left*nodes[i].right*nodes[end].right;
                min = Math.min(min, left+right+cost);
            }
        }

        dp[start][end] = min;

        return min;
    }
}