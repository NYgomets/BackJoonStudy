import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String check = br.readLine();
        int sum = 0;

        for (int i=0; i<num; i++) {
            int value = Integer.parseInt(String.valueOf(check.charAt(i)));
            sum += value;
        }

        System.out.println(sum);
    }
}