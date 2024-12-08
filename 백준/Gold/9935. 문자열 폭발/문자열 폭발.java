import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String s = br.readLine();
        String bomb = br.readLine();
        Stack<Character> storage = new Stack<>();
        int count = 0;
        int len = bomb.length()-1;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);

            while (!stack.isEmpty() && bomb.charAt(len) == stack.peek()) {
                storage.add(stack.pop());
                len -= 1;
                count++;
                if (len < 0) {
                    break;
                }
            }


            if (count != bomb.length()) {
                while (!storage.isEmpty()) {
                    stack.push(storage.pop());
                }
            }
            storage.clear();
            len = bomb.length()-1;
            count = 0;
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
