import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int sum = 0;
    static int n;
    static int m;
    static Integer[][] dp;
    static List<Node> nodes;
    static class Node {
        int v;
        int c;

        public Node(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int k = 1;
            while (c > 0) {
                int count = Math.min(k, c);
                nodes.add(new Node(a * count, b * count));
                sum++;
                c -= count;
                k *= 2;
            }
        }

        dp = new Integer[sum][m+1];
        int result = dfs(0, 0);

        System.out.println(result);
    }

    private static int dfs(int choose, int weight) {
        if (choose >= sum) {
            return 0;
        }

        if (dp[choose][weight] != null) {
            return dp[choose][weight];
        }

        int max = 0;
        max = Math.max(max, dfs(choose+1, weight));
        if (weight + nodes.get(choose).v <= m) {
            max = Math.max(max, nodes.get(choose).c + dfs(choose+1, nodes.get(choose).v + weight));
        }

        dp[choose][weight] = max;

        return max;
    }
}