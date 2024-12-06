import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k  = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long[] div = new long[n];
        long prev = 0;
        for (int i=0; i<n; i++) {
            div[i] = arr[i]-prev;
            prev = arr[i];
        }

        Arrays.sort(div);
        long result = 0;
        for (int i=0; i<n-k; i++) {
            result+=div[i];
        }
        System.out.println(result);
    }
}
