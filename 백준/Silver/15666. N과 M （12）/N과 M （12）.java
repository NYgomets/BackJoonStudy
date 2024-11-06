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
        back(0, sb, 0, 0);
    }

    private static void back(int depth, StringBuffer sb, int lastUsed, int check) {
        if (depth == m) {
            System.out.println(sb);
            return;
        }

        for (int i=0; i<n; i++) {
            if (arr[i]!=lastUsed && arr[i] >= check) {
                sb.append(arr[i]).append(" ");
                check = arr[i];
                back(depth+1, sb, lastUsed, check);
                sb.delete(sb.length()-(String.valueOf(arr[i]).length()+1), sb.length());
                lastUsed = arr[i];
            }
        }
    }
}