import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int mod = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int check;
        if (n<0) {
            check = minusFibo(n);
        } else {
            check = plusFibo(n);
        }

        if (check<0) {
            System.out.println(-1);
            System.out.println(Math.abs(check));
        } else if (check==0) {
            System.out.println(0);
            System.out.println(0);
        } else {
            System.out.println(1);
            System.out.println(Math.abs(check));
        }
    }

    private static int plusFibo(int n) {
        if (n<=1) {
            return n%mod;
        }

        int prev2=0;
        int prev1=1;
        for (int i=2; i<=n; i++) {
            int temp = (prev2+prev1)%mod;
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }

    private static int minusFibo(int n) {
        if (n==-1) {
            return 1;
        }

        int prev1 = 1;
        int prev2 = -1;
        for (int i=-3; i>=n; i--) {
            int temp = (prev1-prev2)%mod;
            prev1 = prev2;
            prev2 = temp;
        }

        return prev2;
    }
}