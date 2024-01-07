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

        int determine = b*d - a*e;

        if (determine != 0) {
            int x = (b*f - c*e) / determine;
            int y = (c*d - a*f) / determine;

            System.out.println(x + " " + y);
        }

    }
}