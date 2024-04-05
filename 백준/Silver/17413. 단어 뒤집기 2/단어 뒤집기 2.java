import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String length = br.readLine();

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean check = false;
        for (int i=0; i<length.length(); i++) {
            char c = length.charAt(i);
            if (c == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                check = true;
            } else if (c == '>') {
                check = false;
                sb.append(c);
                continue;
            }
            
            if (check) {
                sb.append(c);
            } else if (!check) {
                if (c == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                } else {
                    stack.push(String.valueOf(c));
                }
            }

            if (i == length.length() -1) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }
        System.out.println(sb);
    }
}