import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int im = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());

        int result = 0;
        while (true) {
            if (im == kim) {
                break;
            }

            im = im/2 + im%2;
            kim = kim/2 + kim%2;
            result++;
        }

        System.out.println(result);
    }
}