import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static Node[] nodes;
    static class Node {
        int t;
        int p;
        Node(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(a, b);
        }

        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            // 1. 상담을 선택하는 경우
            if (i + nodes[i].t <= n) {
                dp[i + nodes[i].t] = Math.max(dp[i + nodes[i].t], dp[i] + nodes[i].p);
            }
            // 2. 상담을 선택하지 않는 경우
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[n]);
    }
}