import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int whiteCount = 0;
        for (int i=0; i<8; i++) {
            String s = br.readLine();
            for (int j=0; j<8; j++) {
                if ((i + j) % 2 == 0 && s.charAt(j) == 'F') {
                    whiteCount++;
                }
            }
        }
        
        System.out.println(whiteCount);
    }
}
