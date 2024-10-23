import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int chance = Integer.parseInt(br.readLine());
        int check = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        StringBuilder result = new StringBuilder();

        for (int i=0; i<chance; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > stack.peek()) {
                while (num > stack.peek()) {
                    check++;
                    stack.push(check);
                    result.append("+\n");
                }
                if (check > num) {
                    System.out.println("NO");
                    return;
                }
            }

            if (num < stack.peek()) {
                while (num < stack.peek()) {
                    result.append("-\n");
                    stack.pop();
                }
            }

            if (num == stack.peek()) {
                result.append("-\n");
                stack.pop();
            }

        }

        System.out.println(result);
    }
}