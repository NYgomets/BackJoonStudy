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

        int test = scanner.nextInt();
        String s = "";

        for (int i =0; i<test; i++) {
            s += "*";
            System.out.println(s);
        }
    }
}