import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        for (int c : list) {
            System.out.print(c + " ");
        }
    }
}