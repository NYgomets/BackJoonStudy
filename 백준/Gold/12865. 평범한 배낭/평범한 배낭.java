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
        int weight;
        int value;

        public Node(int weight, int value) {
            this.weight = weight;
            this.value = value;
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
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(w, v);
        }

        System.out.println(find(0, 0));
    }

    private static int find(int choose, int weight) {
        if (choose>=n) {
            return 0;
        }

        if (dp[choose][weight] != null) {
            return dp[choose][weight];
        }

        int max = 0;
        max = Math.max(max, find(choose+1, weight));
        if (weight+nodes[choose].weight<=k) {
            max = Math.max(max, nodes[choose].value+find(choose+1, weight+nodes[choose].weight));
        }

        dp[choose][weight] = max;

        return max;
    }
}