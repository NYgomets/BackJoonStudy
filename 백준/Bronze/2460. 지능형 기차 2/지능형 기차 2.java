import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int human = 0;
        int max = 0;
        for (int i=0; i<10; i++) {
            int out = s.nextInt();
            int in = s.nextInt();
            human -= out;
            human += in;
            if (human>max) {
                max = human;
            }
        }
        System.out.println(max);
    }
}