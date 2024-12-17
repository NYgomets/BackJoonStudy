import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }
        BigInteger prev2 = BigInteger.ZERO;
        BigInteger prev1 = BigInteger.ONE;
        for (int i=2; i<=n; i++) {
            BigInteger temp = prev1.add(prev2);
            prev2 = prev1;
            prev1 = temp;
        }

        System.out.println(prev1);
    }
}