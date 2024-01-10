import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        List<String> arr = new ArrayList<>();

        for (int i=0; i<n; i++) {
            arr.add(i, s.next());
        }

        arr.sort((s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            } else {
                return s1.compareTo(s2);
            }
        });

        List<String> uniqueList = new ArrayList<>();
        for (String string:arr) {
            if (!uniqueList.contains(string)) {
                uniqueList.add(string);
            }
        }

        for (String string : uniqueList) {
            System.out.println(string);
        }
    }
}