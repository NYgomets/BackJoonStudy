import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String result = "";
        for (int i=1; i<input.length()-1; i++) {
            for (int j=i+1; j<input.length(); j++) {
                StringBuilder first = new StringBuilder(input.substring(0,i)).reverse();
                StringBuilder second = new StringBuilder(input.substring(i, j)).reverse();
                StringBuilder third = new StringBuilder(input.substring(j)).reverse();

                String candidate = first.toString()+second.toString()+third.toString();

                if (result.isEmpty() || result.compareTo(candidate) > 0 ) {
                    result = candidate;
                }
            }
        }

        System.out.println(result);
    }
}
