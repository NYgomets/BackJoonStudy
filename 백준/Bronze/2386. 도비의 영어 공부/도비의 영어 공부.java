import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if (s.equals("#")) {
                break;
            }

            char check = s.charAt(0);
            String string = s.substring(2);

            int count = 0;
            for (int i=0; i<string.length(); i++) {
                if (Character.toLowerCase(string.charAt(i)) == check) {
                    count++;
                }
            }

            System.out.println(check + " " + count);
        }
    }
}