import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static Integer[][] dp;
    static final int MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new Integer[n+1][m+1];
        int result = check(0, 0);
        System.out.println(result);
    }

    private static int check(int sum, int num) {
        if (sum>n || num>m) {
            return 0;
        }

        if (sum==n && num==m) {
            return 1;
        }

        if (dp[sum][num] != null) {
            return dp[sum][num];
        }

        int result = 0;
        for (int i=0; i<=n; i++) {
            result = ((result+check(sum+i, num+1))%MOD);
        }

        dp[sum][num] = result;

        return result;
    }
}