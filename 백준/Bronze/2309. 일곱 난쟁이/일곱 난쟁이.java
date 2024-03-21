import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] check = new int[9];
        int sum = 0;

        for (int i=0; i<check.length; i++) {
            check[i] = Integer.parseInt(br.readLine());
            sum += check[i];
        }

        Arrays.sort(check);
        int a = 0;
        int b = 0;

        for (int i=0; i<check.length-1; i++) {
            for (int j=i+1; j< check.length; j++) {
                if ((sum - check[i] - check[j]) == 100) {
                    a = i;
                    b = j;
                }
            }
        }

        for (int i=0; i<check.length; i++)
            if (!((i == a) || (i == b))) {
                System.out.println(check[i]);
            }
    }
}