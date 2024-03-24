import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            return o2-o1;
        });

        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            int check = Integer.parseInt(br.readLine());
            if (check == 0) {
                if (!priorityQueue.isEmpty()) {
                    System.out.println(priorityQueue.poll());
                } else {
                    System.out.println(0);
                }
            } else {
                priorityQueue.add(check);
            }
        }
    }
}