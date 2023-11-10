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
        String A = "";

        for (int i =0; i<test; i++) {
            for (int j=0; j<test-(i+1); j++) {
                System.out.print(" ");
            }
            for (int x=0; x<i + 1; x++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}