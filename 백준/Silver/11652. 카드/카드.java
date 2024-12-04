import java.io.*;
import java.util.*;

public class Main {
    static HashMap<Long, Integer> map = new HashMap<>(); // 숫자, 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            long current = Long.parseLong(br.readLine());
            map.put(current, map.getOrDefault(current, 0)+1);
        }

        int max = 0;
        long result = 0;
        for (long i : map.keySet()) {
            Integer va = map.get(i);
            if (va > max) {
                max = va;
                result = i;
            } else if (va == max) {
                result = Math.min(i, result);
            }
        }

        System.out.println(result);
    }
}