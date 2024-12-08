import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int l=0; l<t; l++) {
            String string = br.readLine();
            String[] split = string.split(" ");
            StringBuilder result = new StringBuilder();

            for (int i=0; i< split.length; i++) {
                StringBuilder sb = new StringBuilder(split[i]);
                result.append(sb.reverse()).append(" ");
            }
            System.out.println(result);
        }
    }
}
