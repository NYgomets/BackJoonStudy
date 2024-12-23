import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String first;
    static String second;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        first = br.readLine();
        second = br.readLine();

        dp = new Integer[first.length()][second.length()];
        int result = find(0, 0);

        System.out.println(result);
    }

    private static int find(int currentF, int currentS) {
        if (currentF>=first.length() || currentS>=second.length()) {
            return 0;
        }

        if (dp[currentF][currentS] != null) {
            return dp[currentF][currentS];
        }

        int result = 0;
        if (first.charAt(currentF)==second.charAt(currentS)) {
            result = 1+find(currentF+1, currentS+1);
        } else {
            result = Math.max(find(currentF+1, currentS), find(currentF, currentS+1));
        }

        dp[currentF][currentS] = result;

        return result;
    }
}