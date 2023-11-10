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

        int sum = scanner.nextInt();
        int test = scanner.nextInt();

        int price;
        int kind;
        int plus = 0;

        for (int i=0; i<test; i++) {
            price = scanner.nextInt();
            kind = scanner.nextInt();
            plus += (price*kind);
        }
        
        if (sum == plus) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}