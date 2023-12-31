import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long sum=0;

        if (a==1) {
            System.out.println(5);
            return;
        } else {
            for (long i=0; i<=a-2; i++) {
                sum += (7 + 3*i);
            }
            System.out.println((sum+5) % 45678);
        }
    }
}