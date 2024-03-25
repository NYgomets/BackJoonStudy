import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

public class Main {

    static int check(int i) {
        int sum = i;

        while (i!=0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        boolean[] arr =  new boolean[10001];
        Arrays.fill(arr, true);

        for (int i=1; i<arr.length; i++) {
            int n = check(i);

            if (n < 10001) {
                arr[n] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<arr.length; i++) {
            if (arr[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}