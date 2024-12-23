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
        StringBuilder sb = new StringBuilder();
        int a = 0;
        int b = 0;
        while (a<first.length() && b<second.length()) {
            if (first.charAt(a) == second.charAt(b)) {
                sb.append(first.charAt(a));
                a++;
                b++;
            } else {
                if (a+1<first.length() && dp[a+1][b]>= (b+1<second.length() ? dp[a][b+1] : 0)) {
                    a++;
                } else {
                    b++;
                }
            }
        }

        System.out.println(sb);
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