import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean[] booleans = new boolean[31];

        for (int i = 1; i < 29; i++) {
            booleans[scanner.nextInt()] = true;
        }

        for (int i=1; i<booleans.length; i++) {
            if (!booleans[i]) {
                System.out.println(i);
        }
        }
    }
}