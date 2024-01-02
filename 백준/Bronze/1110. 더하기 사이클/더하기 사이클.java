import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int original = n;
        int cycle = 0;

        do {
            int first = n/10;
            int second = n%10;
            int third = (first+second) % 10;
            n = second*10 + third;
            cycle++;
        } while (n != original);

        System.out.println(cycle);
    }
}