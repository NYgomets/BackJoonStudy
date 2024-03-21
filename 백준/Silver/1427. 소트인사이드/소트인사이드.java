import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = String.valueOf(br.readLine());
        char[] charArray = N.toCharArray();

        Arrays.sort(charArray);

        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(charArray).reverse());
    }
}