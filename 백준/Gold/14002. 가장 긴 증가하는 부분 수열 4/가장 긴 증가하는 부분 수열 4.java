import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int[] trace;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        trace = new int[n];
        dp = new Integer[n];
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int start = -1;
        for (int i=0; i<n; i++) {
            if (result < find(i)) {
                result = find(i);
                start = i;
            }
        }

        System.out.println(result);
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(arr[start]).append(" ");
            start = trace[start];
        } while (start != 0);

        System.out.println(sb);
    }

    private static int find(int i) {
        if (dp[i] != null) {
            return dp[i];
        }

        dp[i] = 1;
        for (int j=i+1; j<n; j++) {
            if (arr[j]>arr[i]) {
                if (dp[i] < 1+find(j)) {
                    dp[i] = 1+find(j);
                    trace[i] = j;
                }
            }
        }

        return dp[i];
    }
}