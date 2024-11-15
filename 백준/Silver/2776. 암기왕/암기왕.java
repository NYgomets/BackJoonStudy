import java.io.*;
import java.util.*;

public class Main {
    static int t;
    static HashMap<Integer, Integer> hashMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            hashMap = new HashMap<>();
            int n1 = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n1; j++) {
                int a = Integer.parseInt(st.nextToken());
                hashMap.put(a, 1);
            }
            int n2 = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int k=0; k<n2; k++) {
                int a = Integer.parseInt(st.nextToken());
                if (k<n2-1) {
                    sb.append(hashMap.getOrDefault(a, 0)).append("\n");
                } else if (k == n2-1) {
                    sb.append(hashMap.getOrDefault(a, 0));
                }
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}