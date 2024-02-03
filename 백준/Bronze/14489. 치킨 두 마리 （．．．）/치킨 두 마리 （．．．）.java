import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int A = s.nextInt();
        int B = s.nextInt();
        int C = s.nextInt();
        s.close();

        if (A + B >= (2 * C)) {
            System.out.println((A + B) - (2 * C));
        } else {
            System.out.println(A + B);
        }
    }
}