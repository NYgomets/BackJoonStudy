import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        char[] charArray = br.readLine().toCharArray();
        BigInteger result = BigInteger.ZERO;
        for (int i=0; i<l; i++) {
            result = result.add(BigInteger.valueOf(charArray[i]-96).multiply(BigInteger.valueOf(31).pow(i)));
        }

        System.out.println(result.remainder(BigInteger.valueOf(1234567891)));
    }
}