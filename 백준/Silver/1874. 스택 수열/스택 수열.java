import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] checkArr = new int[n];
        for (int i=0; i<n; i++) {
            checkArr[i] = s.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int i=0;
        int check = 0;
        stack.push(0);
        Queue<String> result = new ArrayDeque<>();

        while (!stack.isEmpty()) {
            if (stack.peek() < checkArr[i]) {
                check++;
                stack.push(check);
                result.add("+");
            } else if (stack.peek() == checkArr[i]) {
                stack.pop();
                result.add("-");
                i++;
                if (i == n) {
                    break;
                }
            } else if (stack.peek() > checkArr[i]) {
                System.out.println("NO");
                return;
            }
        }

        while (!result.isEmpty()) {
            System.out.println(result.poll());
        }
    }
}