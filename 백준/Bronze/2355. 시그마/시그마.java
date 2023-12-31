import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (b >= a) {
            System.out.println((long)(a + (long)b) * (b - (long)a + 1) / 2);
        } else {
            System.out.println((long)(a + (long)b) * (a - (long)b + 1) / 2);
        }
    }
}