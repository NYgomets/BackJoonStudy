import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static Integer[] dp;
    static Node[] nodes;
    static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new Integer[n];
        nodes = new Node[n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(a, b);
        }

        Arrays.sort(nodes, ((o1, o2) -> o1.left-o2.left));

        int result = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            result = Math.min(result, n-find(i));
        }

        System.out.println(result);
    }

    private static int find(int current) {
        if (dp[current] != null) {
            return dp[current];
        }

        int result = 1;
        for (int i=current+1; i<n; i++) {
            if (nodes[i].right > nodes[current].right) {
                result = Math.max(result, 1+find(i));
            }
        }

        dp[current] = result;

        return result;
    }
}