import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] alpha = new Integer[26];
        Arrays.fill(alpha, 0);

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            char[] charArray = br.readLine().toCharArray();
            int start = charArray.length-1;
            for (int j=0; j<charArray.length; j++) {
                int k = charArray[j] - 65;
                alpha[k] += (int) Math.pow(10, start);
                start--;
            }
        }

        Arrays.sort(alpha, Comparator.reverseOrder());
        int count = 9;
        long result = 0;
        for (int i=0; i<26; i++) {
            if (alpha[i] != 0) {
                result += (long) alpha[i] *count;
                count--;
            }
        }

        System.out.println(result);
    }
}
