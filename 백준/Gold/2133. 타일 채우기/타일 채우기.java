import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new Integer[n+1];
        if (n%2 != 0) {
            System.out.println(0);
            return;
        }

        dp[0] = 1;
        dp[2] = 3;
        for(int i = 4; i <= n;i=i+2){
            dp[i] = dp[i-2] * 3;
            for(int j = i;j>=4;j = j-2){
                dp[i] += dp[i-j] * 2;
            }
        }


        System.out.println(dp[n]);
    }
}