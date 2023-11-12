import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[9];
        for (int i=0; i<9; i++) {
            a[i] = scanner.nextInt();
        }
        int max = a[0];
        int count = 0;
        for (int i=0; i<9; i++) {
            if (max < a[i]) {
                max = a[i];
                count = i;
            }
        }

        System.out.println(max);
        System.out.println(count+1);
    }
}