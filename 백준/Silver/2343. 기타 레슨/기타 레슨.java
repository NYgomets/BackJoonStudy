import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int max = 0;
    static int total = 0;
    static int[] arr;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (max < arr[i]) {
                max = arr[i];
            }

            total += arr[i];
        }

        int start = max;
        int end = total;
        while (start <= end) {
            int mid = (start+end) / 2;
            
            if (check(mid) <= m) {
                result = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        System.out.println(result);
    }

    private static int check(int mid) {
        int count = 1;

        int sum = 0;
        for (int i=0; i<n; i++) {
           if (sum + arr[i] > mid) {
               count++;
               sum = arr[i];
           } else {
               sum += arr[i];
           }
        }
        
        return count;
    }
}
