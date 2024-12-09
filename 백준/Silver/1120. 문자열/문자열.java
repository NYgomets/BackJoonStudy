import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String first = st.nextToken();
        String second = st.nextToken();

        int difLen = second.length()-first.length();

        if (first.length() == second.length()) {
            int diff = 0;
            for (int i=0; i< first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    diff++;
                }
            }
            System.out.println(diff);
        } else if (second.contains(first)){
            System.out.println(0);
        } else {
            for (int i=0; i<=difLen; i++) {
                int count = 0;
                for (int j=0; j<first.length(); j++) {
                    if (first.charAt(j) != second.charAt(i+j)) {
                        count++;
                    }
                }
                min = Math.min(min, count);
            }

            System.out.println(min);
        }
    }
}
