import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m+1];
        for (int i=2; i<=m; i++) {
            arr[i] = i;
        }

        prime_number(m, arr);

        for (int i=n; i<=m; i++) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
    }

    private static void prime_number(int m, int[] arr) {
        for (int i=2; i<=(m/2); i++) {
            int mul = 2;
            while (i*mul <= m) {
                arr[i*mul] = 0;
                mul++;
            }
        }
    }
}