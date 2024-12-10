import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = n-1;
        long sum = Integer.MAX_VALUE;
        long result = 0;
        while (start<end) {
            long checkSum = arr[start]+arr[end];
            long abs = Math.abs(checkSum);
            if (sum > abs) {
                sum = abs;
                result = checkSum;
            }

            if (checkSum > 0) {
                end--;
            } else if (checkSum < 0) {
                start++;
            } else {
                result = 0;
                break;
            }
        }

        System.out.println(result);
    }
}
