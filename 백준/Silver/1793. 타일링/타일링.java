import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] arr = new BigInteger[251];
        arr[0] = BigInteger.ONE;
        arr[1] = BigInteger.ONE;
        for (int i=2; i<=250; i++) {
            arr[i] = arr[i-1].add(arr[i-2].multiply(BigInteger.TWO));
        }

        String s;
        while ((s=br.readLine()) != null) {
            int n = Integer.parseInt(s);
            System.out.println(arr[n]);
        }
    }
}