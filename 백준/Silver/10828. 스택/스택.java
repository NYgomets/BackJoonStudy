import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<N; i++) {
            String check = br.readLine();

            if (check.contains("push")) {
                String[] split = check.split(" ", 2);
                int num = Integer.parseInt(split[1]);
                stack.push(num);
            } else if (check.equals("pop")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.pop());
                } else {
                    System.out.println(-1);
                }
            } else if (check.equals("size")) {
                System.out.println(stack.size());
            } else if (check.equals("empty")) {
                if (!stack.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            } else if (check.equals("top")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.peek());
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}