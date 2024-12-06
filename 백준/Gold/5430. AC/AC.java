import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int l=0; l<t; l++) {
            String command = br.readLine();
            int size = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String[] split = input.substring(1, input.length() - 1).split(",");
            Deque<String> deque = new ArrayDeque<>();
            for (int i=0; i<size; i++) {
                deque.add(split[i]);
            }

            boolean reverse = false;
            boolean error = false;
            for (char c : command.toCharArray()) {
                if (c == 'R') {
                    reverse = !reverse;
                } else if (c == 'D') {
                    if (!deque.isEmpty()) {
                        if (reverse) {
                            deque.pollLast();
                        } else {
                            deque.pollFirst();
                        }
                    } else {
                        error = true;
                        break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            if (error) {
                sb.append("error");
            } else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    if (reverse) {
                        if (deque.size()>1) {
                            sb.append(deque.pollLast()).append(",");
                        } else {
                            sb.append(deque.pollLast());
                        }
                    } else {
                        if (deque.size()>1) {
                            sb.append(deque.pollFirst()).append(",");
                        } else {
                            sb.append(deque.pollFirst());
                        }
                    }
                }
                sb.append("]");
            }
            System.out.println(sb);
        }
    }
}
