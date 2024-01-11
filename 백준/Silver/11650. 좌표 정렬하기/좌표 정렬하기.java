import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] key = new int[n];
        int[] value = new int[n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            key[i] = x;
            value[i] = y;
        }

        int[][] pairs = new int[n][2];
        for (int i=0; i<n; i++) {
            pairs[i][0] = key[i];
            pairs[i][1] = value[i];
        }

        Arrays.sort(pairs, Comparator.comparingInt((int[] arr) -> arr[0]).thenComparingInt(arr -> arr[1]));

        for (int i=0; i<n; i++) {
            System.out.println(pairs[i][0] + " " + pairs[i][1]);
        }
    }
}