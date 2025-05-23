import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int start = 0;
        int end = n-1;
        int sum = Integer.MAX_VALUE;
        int[] result = new int[2];
        while (start<end) {
            int sumCheck = arr[start]+arr[end];
            if (sum > Math.abs(sumCheck)) {
                sum = Math.abs(sumCheck);
                result[0] = arr[start];
                result[1] = arr[end];
            }
            if (0 < sumCheck) {
                end--;
            } else if (0 > sumCheck) {
                start++;
            } else {
                result[0] = arr[start];
                result[1] = arr[end];
                break;
            }

        }

        Arrays.sort(result);
        System.out.println(result[0] + " " + result[1]);
    }
}