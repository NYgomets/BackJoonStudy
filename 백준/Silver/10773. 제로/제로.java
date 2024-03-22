import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int i=0; i<K; i++) {
            int check = Integer.parseInt(br.readLine());
            if (check == 0) {
                Integer pop = stack.pop();
                sum -= pop;
            } else {
                Integer push = stack.push(check);
                sum += push;
            }
        }

        System.out.println(sum);
    }
}