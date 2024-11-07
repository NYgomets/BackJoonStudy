import java.io.*;
import java.math.BigInteger;
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

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        back(0, sb, result);

        System.out.println(result);
    }

    private static void back(int depth, StringBuilder sb, StringBuilder result) {
        if (depth == m) {
            result.append(sb).append("\n");
            return;
        }

        for (int i=0; i<n; i++) {
            sb.append(arr[i]).append(" ");
            back(depth+1, sb, result);
            sb.delete(sb.length()-(String.valueOf(arr[i]).length()+1), sb.length());
        }
    }
}