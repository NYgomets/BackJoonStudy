import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int count_5 = t / 300;
        t = t % 300;

        int count_1 = t / 60;
        t = t % 60;

        int count_10 = t / 10;
        t = t % 10;

        if (t == 0) {
            System.out.println(count_5 + " " + count_1 + " " + count_10);
        } else {
            System.out.println(-1);
        }
    }
}
