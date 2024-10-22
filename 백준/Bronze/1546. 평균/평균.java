import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int subNum = Integer.parseInt(br.readLine());
        String givenNum = br.readLine();
        double sum = 0;
        int max = 0;
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(givenNum);
        while (st.hasMoreTokens()) {
            int check = Integer.parseInt(st.nextToken());
            list.add(check);
            if (check > max) {
                max = check;
            }
        }

        for (int i=0; i<subNum; i++) {
            sum += (double) list.get(i)/max*100;
        }

        System.out.println(sum/subNum);

    }
}