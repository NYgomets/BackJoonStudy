import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        int start = 0;
        int end = N-1;
        while (end > start) {
            if (M > (arr[start]+arr[end])) {
                start++;
            } else if (M < (arr[start]+arr[end])) {
                end--;
            } else {
                count++;
                start++;
            }
        }

        System.out.println(count);
    }
}