import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int low = 1;
        int high = arr[n-1] - arr[0];
        while (low <= high) {
            int mid = (low+high) / 2;

            if (check(mid) >= m) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        
        System.out.println(high);
    }

    private static int check(int mid) {
        int count = 1;
        int last = arr[0];

        for (int i=1; i<n; i++) {
            int current = arr[i];

            if (current-last >= mid) {
                count++;
                last = current;
            }
        }
        return count;
    }
}