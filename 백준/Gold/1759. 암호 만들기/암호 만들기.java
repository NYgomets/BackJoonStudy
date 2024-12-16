import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int l;
    static int c;
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<c; i++) {
            list.add(st.nextToken());
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        dfs(0, sb);
    }

    private static void dfs(int count, StringBuilder sb) {
        if (count==l) {
            if (check(sb)) {
                System.out.println(sb);
                return;
            }
        }

        for (String s : list) {
            if (safe(s, sb)) {
                sb.append(s);
                dfs(count+1, sb);
                sb.delete(sb.length()-1, sb.length());
            }
        }
    }

    private static boolean safe(String s, StringBuilder sb) {
        String current = sb.toString();

        if (!sb.isEmpty()) {
            char last = current.charAt(current.length()-1);
            if (last >= s.charAt(0)) {
                return false;
            }
        }

        return true;
    }

    private static boolean check(StringBuilder sb) {
        String current = sb.toString();

        int first = 0;
        int second = 0;

        for (int i=0; i<current.length(); i++) {
            if (current.charAt(i) == 'a' || current.charAt(i) == 'e' || current.charAt(i) == 'i' || current.charAt(i) == 'o' || current.charAt(i) == 'u') {
                first++;
            } else {
                second++;
            }
        }

        if (first<1 || second<2) {
            return false;
        }

        return true;
    }
}