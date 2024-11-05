import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static boolean[] visitedArr;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visitedArr = new boolean[n+1];
        StringBuffer sb = new StringBuffer();
        back(0, sb, 1);
    }

    private static void back(int depth, StringBuffer sb, int start) {
        if (depth == m) {
            System.out.println(sb);
            return;
        }

        for (int i=start; i<=n; i++) {
            sb.append(i).append(" ");
            back(depth+1, sb, i);
            sb.delete(sb.length()-2, sb.length());
        }
    }
}