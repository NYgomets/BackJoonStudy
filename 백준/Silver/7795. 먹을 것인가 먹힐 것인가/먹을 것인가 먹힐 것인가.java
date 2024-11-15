import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int l=0; l<t; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] aN = new int[a];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<a; i++) {
                aN[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(aN);
            int[] bN = new int[b];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<b; i++) {
                bN[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(bN);

            int count = 0;
            for (int i=0; i<a; i++) {
                for (int j=0; j<b; j++) {
                    if (aN[i] > bN[j]) {
                        count++;
                    } else {
                        break;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
