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
        int[] rope_w = new int[N];
        int[] check = new int[N];
        int count = N;

        for (int i=0; i<N; i++) {
            rope_w[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope_w);

        for (int j=0; j<N; j++) {
            check[j] = rope_w[j] * count;
            count--;
        }

        Arrays.sort(check);

        System.out.println(check[N-1]);
    }
}