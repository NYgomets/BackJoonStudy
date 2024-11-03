import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[k];
        for (int i=0; i<k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long start = 1;
        long end = arr[k-1];
        long result = 0;
        while (start <= end) {
            long mid_index = (start+end) / 2;
            long count = 0;
            for (int i=0; i<k; i++) {
                count += arr[i]/mid_index;
            }

            if (count >= n) {
                result = mid_index;
                start = mid_index+1;
            } else if (count < n) {
                end = mid_index-1;
            }
        }

        System.out.println(result);
    }
}