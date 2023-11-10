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

        int hour = scanner.nextInt();
        int minute = scanner.nextInt();

        if (minute>=0 && minute<45 ) {
            minute = minute + 15;
            if (hour == 0) {
                hour = hour + 23;
            } else {
                hour = hour -1;
            }
        } else {
            minute = minute - 45;
        }

        System.out.print(hour + " " + minute);

    }
}