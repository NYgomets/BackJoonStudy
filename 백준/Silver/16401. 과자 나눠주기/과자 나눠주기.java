import java.io.*;
import java.util.*;

public class Main {
    static int m;
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long start = 1;
        long end = arr[n-1];
        long result = 0;
        while (start <= end) {
            long mid = (start+end) / 2;

            int mid_value = 0;
            for (int i=0; i<n; i++) {
                mid_value += arr[i]/mid;
            }

            if (mid_value >= m) {
                result = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        System.out.println(result);
    }
}
