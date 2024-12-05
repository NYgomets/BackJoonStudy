import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();
        List<Long> list = new ArrayList<>();
        for (char c : charArray) {
            list.add((long) (c-'0'));
        }

        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (long c : list) {
            sb.append(c);
        }

        BigInteger check = new BigInteger(sb.toString());
        if (check.mod(BigInteger.valueOf(30)).equals(BigInteger.ZERO)) {
            System.out.println(check);
        } else {
            System.out.println(-1);
        }
    }
}
