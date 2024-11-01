import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        System.out.println(a+b-c);
        String d = a + String.valueOf(b);
        String f = String.valueOf(c);
        System.out.println(Integer.parseInt(d) - Integer.parseInt(f));
    }
}