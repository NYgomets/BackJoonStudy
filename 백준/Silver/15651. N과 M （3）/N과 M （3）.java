import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer();
        StringBuffer result = new StringBuffer();
        back(0, sb, result);

        System.out.println(result);
    }

    private static void back(int depth, StringBuffer sb, StringBuffer result) {
        if (depth==m) {
            result.append(sb).append("\n");
            return;
        }

        for (int i=1; i<=n; i++) {
            sb.append(i).append(" ");
            back(depth+1, sb, result);
            sb.delete(sb.length()-2, sb.length());
        }
    }
}