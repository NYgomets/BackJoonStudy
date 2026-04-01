import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int c;
    static int n;
    static Integer[][] dp;
    static Node[] nodes;
    static class Node {
        int coin;
        int person;

        Node(int c, int p) {
            coin = c;
            person = p;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(a, b);
        }

        dp = new Integer[n][1090];
        int result = dfs(0, 0);
        System.out.println(result);
    }

    private static int dfs(int index, int person) {
        if (index >= n) {
            return Integer.MAX_VALUE;
        }

        if (person >= c) {
            return 0;
        }

        if (dp[index][person] != null) {
            return dp[index][person];
        }

        int min = Integer.MAX_VALUE;
        min = Math.min(min, dfs(index+1, person));
        min = Math.min(min, nodes[index].coin + dfs(index, person + nodes[index].person));

        dp[index][person] = min;

        return min;
    }
}