import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s = br.readLine();
            if (s.equals("end")) {
                break;
            }

            if (eval(s)) {
                System.out.println("<" + s + "> is acceptable.");
            } else {
                System.out.println("<" + s + "> is not acceptable.");
            }
        }
    }

    private static boolean eval(String s) {
        boolean first = false;
        boolean second = false;
        boolean third = true;

        if (s.contains("a") || s.contains("e") || s.contains("i") || s.contains("o") || s.contains("u")) {
            first = true;
        }

        int vowelCount = 0;
        int consonantCount = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                consonantCount = 0;
                vowelCount++;
            } else {
                vowelCount = 0;
                consonantCount++;
            }

            if (vowelCount == 3 || consonantCount == 3) {
                second = false;
                break;
            } else {
                second = true;
            }
        }
        
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                if (s.charAt(i) != 'e' && s.charAt(i) != 'o') {
                    third = false;
                    break;
                }
            }
        }

        return first&&second&&third;
    }
}
