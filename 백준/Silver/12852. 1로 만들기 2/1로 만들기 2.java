import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] trace;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 0;
        trace = new int[n+1];

        System.out.println(makeOne(n));
        StringBuilder sb = new StringBuilder();
        while (n>0) {
            sb.append(n).append(" ");
            n = trace[n];
        }
        System.out.println(sb);
    }

    private static int makeOne(int n) {
        if (n==1) {
            return 0;
        }

        if (arr[n] != -1) {
            return arr[n];
        }

        int result = Integer.MAX_VALUE;

        if (n%3==0) {
            if (result > makeOne(n/3)+1) {
                result = makeOne(n/3)+1;
                trace[n]=n/3;
            }
        }
        if (n%2==0) {
            if (result > makeOne(n/2)+1) {
                result = makeOne(n/2)+1;
                trace[n]=n/2;
            }
        }
        if (result > makeOne(n-1)+1) {
            result = makeOne(n-1)+1;
            trace[n]=n-1;
        }

        arr[n] = result;

        return result;
    }
}