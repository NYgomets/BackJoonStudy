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

        if (grade>=90 && grade<=100) {
            System.out.print("A");
        } else if (grade>=80) {
            System.out.print("B");
        } else if (grade>=70) {
            System.out.print("C");
        } else if (grade>=60) {
            System.out.print("D");
        } else {
            System.out.print("F");
        }
    }
}