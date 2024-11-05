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
        back(0, sb);
    }

    private static void back(int depth, StringBuffer sb) {
        if (depth == m) {
            System.out.println(sb);
            return;
        }

        for (int i=1; i<=n; i++) {
            if (!visitedArr[i]) {
                visitedArr[i] = true;
                sb.append(i).append(" ");
                back(depth+1, sb);
                visitedArr[i] = false;
                sb.delete(sb.length()-2, sb.length());
            }
        }
    }
}