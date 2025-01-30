import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new Integer[10][n+1];
        System.out.println(recursive(0, 0));
    }

    private static int recursive(int num, int idx) {
        if (idx == n) {
            return 1;
        }

        if (dp[num][idx] != null) {
            return dp[num][idx];
        }

        int count = 0;
        for (int i=num; i<10; i++) {
            count += recursive(i, idx+1);
            count %= 10007;
        }

        dp[num][idx] = count;

        return count;
    }
}
