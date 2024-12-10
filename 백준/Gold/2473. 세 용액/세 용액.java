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
        long sum = Long.MAX_VALUE;
        long[] result = new long[3];
        for (int i=0; i<n-2; i++) {
            int middle = i+1;
            int end = n-1;

            while (middle<end) {
                long checkSum = arr[middle]+arr[end]+arr[i];
                long abs = Math.abs(checkSum);
                if (sum > abs) {
                    sum = abs;
                    result[0] = arr[i];
                    result[1] = arr[middle];
                    result[2] = arr[end];
                }

                if (checkSum > 0) {
                    end--;
                } else if (checkSum < 0) {
                    middle++;
                } else {
                    result[0] = arr[i];
                    result[1] = arr[middle];
                    result[2] = arr[end];
                    break;
                }
            }
        }

        for (long c : result) {
            System.out.print(c + " ");
        }
    }
}
