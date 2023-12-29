import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        int d = s.nextInt();
        int e = s.nextInt();
        int f = s.nextInt();
        
        if (a == c) {
            if (b == f) {
                System.out.println(e + " " + d);
            } else if (d == f) {
                System.out.println(e + " " + b);
            }
        } else if (a == e) {
            if (b == d) {
                System.out.println(c + " " + f);
            } else if (f == d) {
                System.out.println(c + " " + b);
            }
        } else if (c == e) {
            if (b == d) {
                System.out.println(a + " " + f);
            } else if (b == f) {
                System.out.println(a + " " + d);
            }
        }
    }
}