import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("\\    /\\");
        bw.newLine();	// 줄 구분자

        bw.write(" )  ( ')");
        bw.newLine();

        bw.write("(  /  )");
        bw.newLine();

        bw.write(" \\(__)|");

        bw.flush();
        bw.close();

    }
}