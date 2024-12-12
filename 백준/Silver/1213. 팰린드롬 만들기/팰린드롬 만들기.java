import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = new int[26];
        char[] input = br.readLine().toCharArray();
        for (char c : input) {
            alpha[c - 'A']++;
        }

        int odd = 0;
        int num = 0;
        for (int i=0; i<26; i++) {
            if (alpha[i]%2 != 0) {
                odd++;
                num = i;
            }

            if (odd>1) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        StringBuilder left = new StringBuilder();
        for (int i=0; i<26; i++) {
            for (int j=1; j<=alpha[i]/2; j++) {
                left.append((char)(i+'A'));
            }
        }
        String result = left.toString();

        if (odd == 1) {
            System.out.println(result+(char)(num+'A')+left.reverse());
        } else {
            System.out.println(result+left.reverse());
        }
    }
}
