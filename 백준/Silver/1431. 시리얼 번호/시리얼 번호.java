import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            list.add(br.readLine());
        }
        
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) return o1.length()-o2.length();

                int sum1 = getSum(o1);
                int sum2 = getSum(o2);
                if (sum1 != sum2) return sum1-sum2;
                return o1.compareTo(o2);
            }

            private int getSum(String s) {
                int sum = 0;
                for (char c : s.toCharArray()) {
                    int i = c - '0';
                    if (0<=i && i<=9) {
                        sum += i;
                    }
                }
                return sum;
            }
        });

        for (String s : list) {
            System.out.println(s);
        }
    }
}
