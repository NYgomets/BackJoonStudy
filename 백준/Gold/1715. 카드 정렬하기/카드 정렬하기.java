import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Queue<Long> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>();
        for (int i=0; i<n ;i++) {
            queue.add(Long.parseLong(br.readLine()));
        }

        long result = 0;
        while (queue.size() > 1) {
            long first = queue.poll();
            long second = queue.poll();
            result += first+second;
            queue.offer(first+second);
        }

        System.out.println(result);
    }
}
