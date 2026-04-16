import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        String plus = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        String check = st.nextToken();
        int result = Integer.parseInt(st.nextToken());

        if (a+b == result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}