import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[][] info = new String[n][2];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            info[i][0] = String.valueOf(st.nextToken());
            info[i][1] = String.valueOf(st.nextToken());
        }

        Arrays.sort(info, Comparator.comparingInt(o -> Integer.parseInt(o[0])));

        for (int i=0; i<n; i++) {
            System.out.println(info[i][0] + " " + info[i][1]);
        }
    }
}