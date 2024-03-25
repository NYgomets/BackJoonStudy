import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 99;

        if (N<100) {
            System.out.println(N);
            return;
        }

        for (int i=100; i<=N; i++) {
            int first = i / 100;
            int s_buffer = i % 100;
            int second = s_buffer / 10;
            int third = s_buffer % 10;
            if ((second-first) == (third-second)) {
                count++;
            }
        }
        System.out.println(count);
    }
}