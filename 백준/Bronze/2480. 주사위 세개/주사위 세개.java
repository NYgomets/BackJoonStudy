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

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int price = 0;

        if (a == b && a == c) {
            price = 10000 + (a*1000);
        } else if ((a == b) || (a == c)) {
            price = 1000 + (a*100);
        } else if (b == c) {
            price = 1000 + (b*100);
        } else {
            if ((a > b) && (a > c)) {
                price = a*100;
            } else if ((b > a) && (b > c)) {
                price = b*100;
            } else {
                price = c*100;
            }
        }

        System.out.print(price);
    }
}