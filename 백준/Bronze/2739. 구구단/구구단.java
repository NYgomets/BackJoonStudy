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

        for (int i = 1; i<=9; i++) {
            System.out.println(a + " * " + i + " = " + a*i);
        }
    }
}