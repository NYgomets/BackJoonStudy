import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int K = s.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        for (int i=1; i<=N; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for (int i=0; i<K-1; i++) {
                Integer num = queue.poll();
                queue.add(num);
            }
            Integer check = queue.poll();
            result.add(check);
        }

        System.out.print("<");
        for (int i=1; i<=N; i++) {
            if (i != N) {
                System.out.print(result.poll() + ", ");
            } else {
                System.out.print(result.poll());
            }
        }
        System.out.print(">");
    }
}