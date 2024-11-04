import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if (n==1) {
            System.out.println(0);
            return;
        }
        arr = new int[n+1];
        for (int i=2; i<=n; i++) {
            arr[i] = i;
        }

        erasto(arr);

        int start = 2;
        int end = 2;
        int sum = arr[2];
        int result = 0;
        while (end<n+1) {
            if (sum < n) {
                end++;
                if (end < n+1) {
                    sum += arr[end];
                }
            } else if (sum > n) {
                sum -= arr[start];
                start++;
            } else {
                if (arr[end] != 0) {
                    result++;
                }
                end++;
                if (end < n+1) {
                    sum += arr[end];
                }
            }
        }
        System.out.println(result);
    }

    private static void erasto(int[] arr) {
        for (int i=2; i<=Math.sqrt(n); i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j=i*i; j<=n; j+=i) {
                arr[j] = 0;
            }
        }
    }
}