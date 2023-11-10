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

        int test = Integer.parseInt(br.readLine());

        for (int i=1; i<=test; i++) {
            st = new StringTokenizer(br.readLine()," ");
            String f = st.nextToken();
            String s = st.nextToken();
            bw.write("Case #"+ i + ": " + f + " + " + s + " = ");
            bw.write(Integer.parseInt(f) + Integer.parseInt(s)+ "\n");
        }
        br.close();

        bw.flush();
        bw.close();

        bw.close();
    }
}