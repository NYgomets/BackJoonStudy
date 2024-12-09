import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        int count = 0;
        while (string.length()>1) {
            count++;
            int sum = 0;
            for (char c : string.toCharArray()) {
                sum += c-'0';
            }
            string = String.valueOf(sum);
        }
        System.out.println(count);
        if (Integer.parseInt(string)%3 ==0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
