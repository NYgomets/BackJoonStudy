import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int test = s.nextInt();

        for (int i=0; i<test; i++) {
            int n = s.nextInt();
            int[] arr = new int[n];
            double sum =0;
            for (int j=0; j<n; j++) {
                int p = s.nextInt();
                sum += p;
                arr[j] = p;
            }
            double avg = sum / n;
            int count = 0;

            for (int j=0; j<n; j++) {
                if (arr[j] > avg) {
                    count++;
                }
            }

            double result = (double)count / (double)n * 100;
            System.out.printf("%.3f", result);
            System.out.println("%");
        }
    }
}