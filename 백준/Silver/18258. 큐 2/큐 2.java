import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        Integer N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int rear = 0;

        for (int i=0; i<N; i++) {
            String check = String.valueOf(br.readLine());
            if (check.contains("push")) {
                String[] split = check.split(" ", 2);
                int rearNum = Integer.parseInt(split[1]);
                rear = rearNum;
                queue.add(rearNum);
            } else if (check.contains("pop")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (check.contains("size")) {
                sb.append(queue.size()).append("\n");
            } else if (check.contains("empty")) {
                if (!queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(1).append("\n");
                }
            } else if (check.contains("front")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.peek()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (check.contains("back")) {
                if (!queue.isEmpty()) {
                    sb.append(rear).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}