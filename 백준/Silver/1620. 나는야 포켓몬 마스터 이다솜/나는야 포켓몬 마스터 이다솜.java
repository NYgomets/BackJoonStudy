import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> map = new HashMap<>();
    static Map<Integer, String> reverse = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i=1; i<=n ;i++ ){
            String s = br.readLine();
            map.put(s, i);
            reverse.put(i, s);
        }
        for (int i=0; i<k; i++) {
            String string = br.readLine();
            if (checkMath(string)) {
                System.out.println(reverse.get(Integer.parseInt(string)));
            } else {
                System.out.println(map.get(string));
            }
        }
    }
    private static boolean checkMath(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
