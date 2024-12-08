import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int zero = 0;
        boolean zeroCheck = false;
        int one = 0;
        boolean oneCheck = false;
        char[] charArray = br.readLine().toCharArray();
        for (char c : charArray) {
            if (c == '0' && !zeroCheck) {
                zeroCheck = true;
                oneCheck = false;
                zero++;
            } else if (c == '1' && !oneCheck) {
                oneCheck = true;
                zeroCheck = false;
                one++;
            }
        }

        int result = Math.min(zero, one);
        System.out.println(result);
    }
}
