import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int back = 0;

        for (int i=0; i<N; i++) {
            String check = br.readLine();

            if (check.contains("push")) {
                String[] split = check.split(" ", 2);
                int num = Integer.parseInt(split[1]);
                back = num;
                queue.add(num);
            } else if (check.equals("pop")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.poll());
                } else {
                    System.out.println(-1);
                }
            } else if (check.equals("size")) {
                System.out.println(queue.size());
            } else if (check.equals("empty")) {
                if (!queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            } else if (check.equals("front")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.peek());
                } else {
                    System.out.println(-1);
                }
            } else if (check.equals("back")) {
                if (!queue.isEmpty()) {
                    System.out.println(back);
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}