import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int n = s.nextInt();

        for (int i=0; i<n; i++) {
            int a = s.nextInt();
            list.add(a);
        }

        Collections.sort(list);

        for (int i:list) {
            System.out.println(i);
        }
    }
}