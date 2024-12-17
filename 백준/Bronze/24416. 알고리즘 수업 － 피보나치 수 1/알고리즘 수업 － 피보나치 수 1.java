import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int checkF = 0;
    static int checkS = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        Arrays.fill(arr, -1);
        arr[0]=0;
        arr[1]=1;
        arr[2]=1;

        first(n);
        second(n);
        System.out.println(checkF + " " + checkS);
    }

    private static int second(int n) {
        if (arr[n]!=-1) {
            return arr[n];
        }

        checkS++;
        return arr[n] = second(n-1)+second(n-2);
    }

    private static int first(int n) {
        if (n==1 || n==2) {
            checkF++;
            return 1;
        } else {
            return first(n-1)+first(n-2);
        }
    }
}