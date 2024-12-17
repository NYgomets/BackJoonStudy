import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BigInteger[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new BigInteger[n+1];

        arr[0] = BigInteger.ZERO;
        arr[1] = BigInteger.ONE;

        System.out.println(fibo(n));
    }

    private static BigInteger fibo(int n) {
        if (arr[n]!=null) {
            return arr[n];
        }

        return arr[n] = fibo(n-1).add(fibo(n-2));
    }
}