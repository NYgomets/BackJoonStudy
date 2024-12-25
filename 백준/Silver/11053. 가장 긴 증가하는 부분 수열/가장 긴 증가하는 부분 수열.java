import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new Integer[n];
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i=0; i<n; i++) {
            result = Math.max(result, find(i));
        }

        System.out.println(result);
    }

    private static int find(int current) {
        if (dp[current] != null) {
            return dp[current];
        }

        int result = 1;
        for (int i=current+1; i<n; i++) {
            if (arr[i] > arr[current]) {
                result = Math.max(result, 1+find(i));
            }
        }

        dp[current] = result;

        return result;
    }
}