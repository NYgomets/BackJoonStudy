import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(makeOne(n,0));
    }

    private static int makeOne(int n, int count) {
        if (n==1) {
            return 0;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int result = Integer.MAX_VALUE;

        if (n%3==0) {
            result = Math.min(result, makeOne(n/3, count)+1);
        }
        if (n%2==0) {
            result = Math.min(result, makeOne(n/2, count)+1);
        }
        result = Math.min(result, makeOne(n-1, count)+1);

        map.put(n, result);

        return result;
    }
}