import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int k = 0;
        int l = 0;

        for(int i = 0; i < N; i++) {
            String string = br.readLine();
            if(string.startsWith("1") || string.startsWith("2")) {
                String[] split = string.split(" ", 2);
                k = Integer.parseInt(split[0]);
                l = Integer.parseInt(split[1]);
            } else {
                k = Integer.parseInt(string);
            }

            switch(k) {
                case 1:
                    queue.addFirst(l);
                    break;
                case 2:
                    queue.add(l);
                    break;
                case 3:
                    if(queue.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(queue.pollFirst()).append("\n");
                    }
                    break;
                case 4:
                    if(queue.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(queue.pollLast()).append("\n");
                    }
                    break;
                case 5:
                    sb.append(queue.size()).append("\n");
                    break;
                case 6:
                    if(queue.isEmpty()) {
                        sb.append("1").append("\n");
                    } else {
                        sb.append("0").append("\n");
                    }
                    break;
                case 7:
                    if(queue.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(queue.peekFirst()).append("\n");
                    }
                    break;
                case 8:
                    if(queue.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(queue.peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}