import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<Long> decrease = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (long i=0; i<10; i++) {
            back(i);
        }
        decrease.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o1.compareTo(o2);
            }
        });
        
        if (decrease.size()<=n) {
            System.out.println(-1);
        } else {
            System.out.println(decrease.get(n));
        }
    }

    private static void back(long num) {
        decrease.add(num);

        long last = num%10;
        for (long i=0; i<last; i++) {
            back(num*10+i);
        }
    }
}
