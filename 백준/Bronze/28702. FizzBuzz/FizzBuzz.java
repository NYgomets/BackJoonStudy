import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=3; i>0; i--) {
            String s = br.readLine();
            if (s.matches("-?\\d+(\\.\\d+)?")) {
                int n = Integer.parseInt(s) + i;
                System.out.println(result(n));
                break;
            }
        }
    }

    public static String result(int check) {
        if (check%3 == 0 && check%5 == 0) {
            return "FizzBuzz";
        } else if (check%3 == 0) {
            return "Fizz";
        } else if (check%5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(check);
        }
    }
}