import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] shirts = new int[6];
        int person = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<6; i++) {
            shirts[i] = Integer.parseInt(st.nextToken());
            person += shirts[i];
        }
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int first = 0;
        int[] second = new int[2];
        for (int j=0; j<6; j++) {
            int k = shirts[j] / t;
            first += k;
            if (shirts[j]%t != 0) {
                first++;
            }
        }
        second[0] = person/p;
        second[1] = person%p;

        System.out.println(first);
        System.out.println(second[0] + " " + second[1]);
    }
}