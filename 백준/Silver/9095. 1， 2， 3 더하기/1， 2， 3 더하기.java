import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int l=0; l<t; l++) {
            int n = Integer.parseInt(br.readLine());
            dp = new Integer[n+1];
            System.out.println(find(0, n));
        }
    }

    private static int find(int current, int goal) {
        if (current == goal) {
            return 1;
        } else if (current > goal) {
            return 0;
        }

        if (dp[current] != null) {
            return dp[current];
        }

        int count = 0;
        count += find(current+1, goal);
        count += find(current+2, goal);
        count += find(current+3, goal);

        dp[current] = count;
        
        return count;
    }
}