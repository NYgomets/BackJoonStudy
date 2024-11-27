import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        if (n == 1) {
            System.out.println(queue.poll());
            return;
        }

        long result = 0;
        Queue<Integer> positive = new PriorityQueue<>((o1, o2) -> o2-o1);
        Queue<Integer> negative = new PriorityQueue<>();
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (poll > 1) {
                positive.add(poll);
            } else if (poll == 1) {
                result += poll;
            } else {
                negative.add(poll);
            }
        }

        while (positive.size()>1) {
            Integer first = positive.poll();
            Integer second = positive.poll();
            result += first*second;
        }
        if (!positive.isEmpty()) {
            result += positive.poll();
        }

        while (negative.size()>1) {
            Integer first = negative.poll();
            Integer second = negative.poll();
            result += first*second;
        }
        if (!negative.isEmpty()) {
            result += negative.poll();
        }

        System.out.println(result);
    }
}
