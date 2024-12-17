import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new long[n+1];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 1;
        System.out.println(fibo(n));
    }

    private static long fibo(int n) {
        if (arr[n]!=-1) {
            return arr[n];
        }

        return arr[n] = fibo(n-1)+fibo(n-2);
    }
}