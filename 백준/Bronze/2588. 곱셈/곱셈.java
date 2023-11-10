import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int A = 0;
        String B = "";

       A = scanner.nextInt();
       B = scanner.next();

        System.out.println(A*Integer.parseInt(String.valueOf(B.charAt(2))));
        System.out.println(A*Integer.parseInt(String.valueOf(B.charAt(1))));
        System.out.println(A*Integer.parseInt(String.valueOf(B.charAt(0))));
        System.out.println(A*Integer.parseInt(B));
    }
}