import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String num = st.nextToken();
        int Num = Integer.parseInt(num);
        char c = num.charAt(0);
        int i = ((int) (c - '0')) + (9 * (num.length() - 1));

        int checkNum = Num - i;
        int sum = 0;

        while (checkNum <= Num) {
            String checknum = String.valueOf(checkNum);
            sum = 0;

            for (int k=0; k<checknum.length(); k++) {
                int a = (int) checknum.charAt(k) - '0';
                sum += a;
            }

            sum += checkNum;

            if (sum == Num) {
                System.out.println(checkNum);
                return;
            } else {
                checkNum++;
            }
        }
            System.out.println(0);
    }
}