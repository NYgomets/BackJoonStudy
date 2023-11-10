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

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (x>0 && y>0) {
            System.out.print("1");
        } else if (x<0 && y>0) {
            System.out.print("2");
        } else if (x<0 && y<0) {
            System.out.print("3");
        } else {
            System.out.print("4");
        }
    }
}