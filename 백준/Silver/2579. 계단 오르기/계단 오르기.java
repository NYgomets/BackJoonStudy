import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] stair;
    static Integer[] memo;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        memo = new Integer[n+1];
        stair = new int[n+1];
        for (int i=1; i<=n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        memo[0] = 0;
        memo[1] = stair[1];
        if (n>=2) {
            memo[2] = stair[1]+stair[2];
        }

        System.out.println(find(n));
    }

    private static int find(int n) {
        if (memo[n] == null) {
            memo[n] = Math.max(find(n-2)+stair[n], find(n-3)+stair[n-1]+stair[n]);
        }

        return memo[n];
    }
}