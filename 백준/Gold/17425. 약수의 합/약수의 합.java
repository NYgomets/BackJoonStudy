import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    static final int MAX = 1000001;
    static long[] f = new long[MAX];
    static long[] g = new long[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i=1; i<MAX; i++) {
            for (int j=i; j<MAX; j+=i) {
                f[j] = f[j] + i;
            }
        }

        for (int i=1; i<MAX; i++) {
            g[i] = g[i-1] + f[i];
        }

        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(g[num]).append("\n");
        }

        System.out.println(sb);
    }
}