import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());

        long n = 0;
        long sum =0;
        while (s-sum>n) {
            n++;
            sum += n;
        }

        System.out.println(n);
    }
}