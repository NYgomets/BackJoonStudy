import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        String num = s.next();
        int Num = Integer.parseInt(num);

        int i = Character.getNumericValue(num.charAt(0)) + 9 * (num.length() - 1);
        int checkNum = Num - i;

        int sum = 0;

        while (checkNum <= Num) {
            String checknum = String.valueOf(checkNum);
            sum = 0;

            for (int k = 0; k < checknum.length(); k++) {
                int a = Character.getNumericValue(checknum.charAt(k));
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

        System.out.println(0); // 조건을 만족하는 숫자를 찾을 수 없을 경우 0 출력
    }
}