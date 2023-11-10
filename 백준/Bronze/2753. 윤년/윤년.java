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

        int grade = scanner.nextInt();

        if (((grade % 4 == 0) && (grade % 100 !=0)) || (grade % 400 == 0) ) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
    }
}