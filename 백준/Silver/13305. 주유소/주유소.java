import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] length;
    static int[] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        length = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<n; i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        cost = new int[n];
        for (int i=0; i<n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0;
        int min = cost[0];
        for (int i=1; i<n; i++) {
            result += (long) min *length[i];
            if (cost[i] < min) {
                min = cost[i];
            }
        }


        System.out.println(result);

    }
}
