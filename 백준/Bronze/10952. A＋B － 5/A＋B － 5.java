import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

       while (true) {
           st = new StringTokenizer(br.readLine(), " ");
           String f = st.nextToken();
           String s = st.nextToken();
           if (f.equals("0") && s.equals("0")) {
               break;
           }
           bw.write(Integer.parseInt(f) + Integer.parseInt(s) + "\n");
       }
        br.close();

        bw.flush();
        bw.close();

        bw.close();
    }
}