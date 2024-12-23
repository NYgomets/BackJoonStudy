import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String first;
    static String second;
    static String third;
    static Integer[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        first = br.readLine();
        second = br.readLine();
        third = br.readLine();

        dp = new Integer[first.length()][second.length()][third.length()];
        int result = find(0, 0, 0);
        System.out.println(result);
    }

    private static int find(int a, int b, int c) {
        if (a>=first.length() || b>=second.length() || c>=third.length()) {
            return 0;
        }

        if (dp[a][b][c] != null) {
            return dp[a][b][c];
        }

        int result = 0;
        if (first.charAt(a) == second.charAt(b) && second.charAt(b) == third.charAt(c)) {
            result = 1 + find(a+1, b+1, c+1);
        } else {
            result = Math.max(result, find(a+1, b, c));
            result = Math.max(result, find(a, b+1, c));
            result = Math.max(result, find(a, b, c+1));
        }

        dp[a][b][c] = result;

        return result;
    }
}