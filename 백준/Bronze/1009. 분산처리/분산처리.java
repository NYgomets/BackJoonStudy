import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int a, b, r;
        for (int j = 0; j < T; j++) {
            String[] input = br.readLine().split(" ");
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            r = 1;

            for (int i = 0; i < b; i++) r = (r * a) % 10;
            if (r == 0) r = 10;
            System.out.println(r);
        }
    }
}
