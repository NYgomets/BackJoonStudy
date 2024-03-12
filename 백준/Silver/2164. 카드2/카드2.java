import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        Queue<Integer> queue = new ArrayDeque<>();

        if (N == 1) {
            System.out.println(1);
            return;
        }

        for (int i=1; i<=N; i++) {
            queue.add(i);
        }

        int change = 0;

        while (true) {
            queue.poll();
            change = queue.poll();
            if (queue.isEmpty()) {
                break;
            }
            queue.add(change);
        }

        System.out.println(change);
    }
}