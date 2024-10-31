import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long n = Long.parseLong(br.readLine());
        BigInteger first = BigInteger.ONE;
        BigInteger second = BigInteger.ONE;
        st = new StringTokenizer(br.readLine());
        for (long i=0; i<n; i++) {
            first = first.multiply(BigInteger.valueOf(Integer.parseInt(st.nextToken())));
        }
        long m = Long.parseLong(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (long i=0; i<m; i++) {
            second = second.multiply(BigInteger.valueOf(Integer.parseInt(st.nextToken())));
        }

        BigInteger gcd = first.gcd(second);
        String string = String.valueOf(gcd);

        if (string.length()<=9) {
            System.out.println(gcd);
        } else {
            System.out.println(string.substring(string.length()-9));
        }
    }
}