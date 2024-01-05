import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] num = new int[Math.abs(n)];
        for (int i=0; i<num.length; i++) {
            num[i] = s.nextInt();
        }
        int m = s.nextInt();
        int[] check = new int[Math.abs(m)];
        for (int i=0; i< check.length; i++) {
            check[i] = s.nextInt();
        }
        Arrays.sort(num);

        for (int i=0; i< check.length; i++) {
            int index = Arrays.binarySearch(num, check[i]);

            if (index>=0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}