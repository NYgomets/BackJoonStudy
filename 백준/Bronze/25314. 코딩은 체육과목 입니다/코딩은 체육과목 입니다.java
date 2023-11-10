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
        StringBuilder stringBuilder = new StringBuilder();

        int test = scanner.nextInt();
        int num = test / 4;

        stringBuilder.append("long ".repeat(Math.max(0, num)));

        System.out.println(stringBuilder + "int");

    }
}