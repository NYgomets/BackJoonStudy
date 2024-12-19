import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] stair;
    static int[] memo;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        memo = new int[n+1];
        stair = new int[n+1];
        for (int i=1; i<=n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        memo[0] = 0;
        memo[1] = stair[1];
        if (n>=2) {
            memo[2] = stair[1]+stair[2];
        }

        for (int i=3; i<=n; i++) {
            memo[i] = Math.max(memo[i-2]+stair[i], memo[i-3]+stair[i-1]+stair[i]);
        }

        System.out.println(memo[n]);
    }
}