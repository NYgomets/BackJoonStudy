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
        int time = scanner.nextInt();

        hour = hour + ((minute+time)/60);
        if (hour >= 24) {
            hour = hour - 24;
        }
        minute = (minute+time) % 60;

        System.out.print(hour + " " + minute);

    }
}