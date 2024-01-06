import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int max = 0;
        int current = 0;
        for (int i=0; i<4; i++) {
            int out = s.nextInt();
            int in = s.nextInt();
            current = current - out + in;
            if (current >= max) {
                max = current;
            }
        }

        System.out.println(max);
    }
}