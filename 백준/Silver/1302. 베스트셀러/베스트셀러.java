import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        int max = 0;

        for (int i=0; i<N; i++) {
            String book = String.valueOf(br.readLine());
            map.put(book, map.getOrDefault(book, 0) + 1);
            max = Math.max(max, map.get(book));
        }

        List<String> result = new LinkedList<>();
        for (Map.Entry<String, Integer> Entry : map.entrySet()) {
            if (Entry.getValue() == max) {
                result.add(Entry.getKey());
            }
        }

        Collections.sort(result);

        System.out.println(result.get(0));
    }
}