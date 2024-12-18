import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long prevF = 1;
        long prevS = 2;
        for (int i=3; i<=n; i++) {
            long temp = (prevF+prevS)%10007;
            prevF = prevS;
            prevS = temp;
        }
        
        if (n==1) {
            System.out.println(prevF);
        } else {
            System.out.println(prevS);
        }
    }
}