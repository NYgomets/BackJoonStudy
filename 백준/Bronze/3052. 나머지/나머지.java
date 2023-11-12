import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int[] a = new int[10];
        int[] count = new int[42];
        int num = 0;
        for (int i=0; i<a.length; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i=0; i<count.length; i++) {
            count[i] = 0;
        }

        for (int i=0; i<a.length; i++) {
            int index = a[i] % 42;
            count[index]++;
        }

        for (int i=0; i<count.length; i++) {
            if (count[i] > 0) {
                num++;
            }
        }

        System.out.println(num);
    }
}