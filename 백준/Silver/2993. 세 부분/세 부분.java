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
                String first = new StringBuilder(input.substring(0,i)).reverse().toString();
                String second = new StringBuilder(input.substring(i,j)).reverse().toString();
                String third = new StringBuilder(input.substring(j)).reverse().toString();
                
                String candidate = first+second+third;
                
                if (result.isEmpty() || result.compareTo(candidate)>0) {
                    result = candidate;
                }
            }
        }

        System.out.println(result);
    }
}
