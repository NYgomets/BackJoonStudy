import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger check = BigInteger.ONE;
        for (int i=n; i>0; i--) {
            check = check.multiply(BigInteger.valueOf(i));
        }
        char[] charArray = String.valueOf(check).toCharArray();

        int count =0;
        for (int i=charArray.length-1; i>=0; i--) {
            if (charArray[i] == '0') {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}