import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            char[] input = br.readLine().toLowerCase().toCharArray();
            boolean check = true;
            for (int j=0; j<input.length/2; j++) {
                if (input[j] != input[input.length-(j+1)]) {
                    check = false;
                    break;
                }
            }

            if (check) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
