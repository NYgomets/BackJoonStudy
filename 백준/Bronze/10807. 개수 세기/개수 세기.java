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
        int num = scanner.nextInt();
        int[] a = new int[num];
        for (int i=0; i<num; i++) {
            a[i] = scanner.nextInt();
        }
        int findNum = scanner.nextInt();
        int step = 0;
        for (int i=0; i<num; i++) {
            if (a[i] == findNum) {
                step++;
            }
        }

        System.out.println(step);
    }
}