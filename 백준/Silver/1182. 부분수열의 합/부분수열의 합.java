import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int count = 0;
    static int n;
    static int s;
    static int[] arr;
    static boolean[] visitedArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        visitedArr = new boolean[n+1];
        arr = new int[n+1];
        st= new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        back(0, 0, 0);

        System.out.println(count);
    }

    private static void back(int depth, int sum, int start) {
        if (depth == n+1) {
            return;
        }

        for (int i=start+1; i<=n; i++) {
            if (!visitedArr[i]) {
                visitedArr[i] = true;
                sum += arr[i];
                if (sum == s) {
                    count++;
                }
                back(depth+1, sum, i);
                visitedArr[i] = false;
                sum -= arr[i];
            }
        }
    }
}