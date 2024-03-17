import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for (int i=0; i<N; i++) {
            String check = br.readLine();

            if (check.contains("push_front")) {
                String[] split = check.split(" ", 2);
                int num = Integer.parseInt(split[1]);
                deque.addFirst(num);
            } else if (check.contains("push_back")) {
                String[] split = check.split(" ", 2);
                int num = Integer.parseInt(split[1]);
                deque.addLast(num);
            } else if (check.equals("pop_front")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.pollFirst());
                } else {
                    System.out.println(-1);
                }
            } else if (check.equals("pop_back")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.pollLast());
                } else {
                    System.out.println(-1);
                }
            } else if (check.equals("size")) {
                System.out.println(deque.size());
            } else if (check.equals("empty")) {
                if (!deque.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            } else if (check.equals("front")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.getFirst());
                } else {
                    System.out.println(-1);
                }
            } else if (check.equals("back")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.getLast());
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}