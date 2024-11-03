import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long m = Long.parseLong(br.readLine());

        long start = 1;
        long end = arr[n-1];
        long result = 0;
        while (start<=end) {
            long mid_index = (start+end) / 2;
            long count = 0;
            for (int i=0; i<n; i++) {
                if (arr[i] <= mid_index) {
                    count += arr[i];
                } else {
                    count += mid_index;
                }
            }

            if (count <= m) {
                result = mid_index;
                start = mid_index+1;
            } else {
                end = mid_index-1;
            }
        }
        System.out.println(result);
    }
}