import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int s;
    static int[] a;
    static int max = 0;
    static long min = Integer.MAX_VALUE;
    static long result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        result = Math.abs(s-a[0]);
        for (int i = 1; i < n; i++) {
            result = check(result, Math.abs(s - a[i]));
        }

        System.out.println(result);
    }

    private static long check(long max, long min) {
        if (max%min != 0) {
            long temp = min;
            min = max%min;
            max = temp;
            return check(max, min);
        } else {
            return min;
        }
    }
}