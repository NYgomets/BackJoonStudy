import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String check = br.readLine();
            if (check.contains("1")) {
                String[] split = check.split(" ", 2);
                stack.push(Integer.parseInt(split[1]));
            } else if (check.contains("2")) {
                if (!stack.isEmpty()) {
                    sb.append(stack.pop()).append("\n");
                } else {
                    sb.append("-1\n");
                }
            } else if (check.contains("3")) {
                sb.append(stack.size()).append("\n");
            } else if (check.contains("4")) {
                if (stack.isEmpty()) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (check.contains("5")) {
                if (!stack.isEmpty()) {
                    sb.append(stack.peek()).append("\n");
                } else {
                    sb.append("-1\n");
                }
            }
        }
        System.out.print(sb);
    }
}