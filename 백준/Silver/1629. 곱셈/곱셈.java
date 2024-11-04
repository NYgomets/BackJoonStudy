import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static long a;
    static long b;
    static long c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        long result = check(b);
        System.out.println(result);
    }

    private static long check(long x) {
       if (x==1) {
           return a%c;
       }

       long temp = check(x/2);

       if (x%2 == 1) {
           return ((temp*temp)%c * a)%c;
       }

       return temp*temp%c;
    }
}