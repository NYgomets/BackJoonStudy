import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static boolean[] visitedArr;
    static int n;
    static int m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        visitedArr = new boolean[n];
        StringBuffer sb = new StringBuffer();
        back(0, sb, 0);
    }

    private static void back(int depth, StringBuffer sb, int lastUsed) {
        if (depth == m) {
            System.out.println(sb);
            return;
        }

        lastUsed = 0;
        for (int i=0; i<n; i++) {
            if (!visitedArr[i] && arr[i]!=lastUsed) {
                visitedArr[i] = true;
                sb.append(arr[i]).append(" ");
                back(depth+1, sb, lastUsed);
                visitedArr[i] = false;
                sb.delete(sb.length()-(String.valueOf(arr[i]).length()+1), sb.length());
                lastUsed = arr[i];
            }
        }
    }
}