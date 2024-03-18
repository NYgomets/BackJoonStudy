import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        for (int i=0; i<T; i++) {
            String check = s.next();
            int result = 0;
            for (int j=0; j<check.length(); j++) {
                if (check.charAt(j) == '(') {
                    result++;
                } else if (check.charAt(j) == ')') {
                    result--;
                }
                if (result < 0) {
                    System.out.println("NO");
                    break;
                }
            }
            if (result == 0) {
                System.out.println("YES");
            } else if (result > 0){
                System.out.println("NO");
            }
        }
    }
}