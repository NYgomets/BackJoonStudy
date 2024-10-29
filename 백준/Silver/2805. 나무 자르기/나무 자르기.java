import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;

        int[] tree = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);


        int start = 0;
        int end = tree[n-1];
        while (start<=end) {
            int mid_check = (start+end)/2;
            long mid_length = 0;
            for (int i=0; i<n; i++) {
                if (tree[i] - mid_check > 0) {
                    mid_length += (tree[i] - mid_check);
                }
            }
            if (mid_length >= m) {
                result = mid_check;
                start = mid_check+1;
            } else if (mid_length < m) {
                end = mid_check-1;
            }
        }

        System.out.println(result);
    }
}