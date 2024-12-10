import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        if (dfs(first, second)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean dfs(String first, String second) {
        if (first.equals(second)) {
            return true;
        }

        if (second.length()<=first.length()) {
            return false;
        }

        if (second.endsWith("A")) {
            if (dfs(first, second.substring(0, second.length()-1))) {
                return true;
            }
        }

        if (second.startsWith("B")) {
            StringBuilder sb = new StringBuilder(second);
            if (dfs(first, sb.deleteCharAt(0).reverse().toString())) {
                return true;
            }
        }

        return false;
    }
}
