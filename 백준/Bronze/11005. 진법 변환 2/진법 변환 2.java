import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        long n = s.nextLong();
        int b = s.nextInt();

        Stack<Long> stack = new Stack<>();
        while (n!=0){
            stack.push(n%b);
            n /= b;
        }
        while (stack.size()!=0){
            long num = stack.pop();
            if (num < 10)
                System.out.print(num);
            else
                System.out.print((char)(num+55));
        }
    }
}