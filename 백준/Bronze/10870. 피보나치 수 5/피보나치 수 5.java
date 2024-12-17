import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }
        arr = new int[n+1];
        Arrays.fill(arr, -1);
        arr[0]=0;
        arr[1]=1;

        System.out.println(second(n));
    }

    private static int second(int n) {
        if (arr[n]!=-1) {
            return arr[n];
        }

        return arr[n] = second(n-1)+second(n-2);
    }
}