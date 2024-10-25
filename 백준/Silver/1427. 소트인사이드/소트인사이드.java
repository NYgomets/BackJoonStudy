import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();
        Arrays.sort(charArray);
        StringBuilder sb = new StringBuilder();
        sb.append(charArray).reverse();

        System.out.print(sb);
    }
}