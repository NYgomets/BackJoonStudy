import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static boolean[] visitedArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visitedArr = new boolean[n];
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        back(0, sb, result, 0 , 0);

        System.out.println(result);
    }

    private static void back(int depth, StringBuilder sb, StringBuilder result, int start, int lastUsed) {
        if (depth == m) {
            result.append(sb).append("\n");
            return;
        }

        for (int i=start; i<n; i++) {
            if (!visitedArr[i] && arr[i] != lastUsed) {
                visitedArr[i] = true;
                sb.append(arr[i]).append(" ");
                back(depth+1, sb, result, i, lastUsed);
                visitedArr[i] = false;
                lastUsed = arr[i];
                sb.delete(sb.length()-(String.valueOf(arr[i]).length()+1), sb.length());
            }
        }
    }
}