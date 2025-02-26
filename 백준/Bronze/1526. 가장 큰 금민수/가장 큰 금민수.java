import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(true) {
           char[] ch = Integer.toString(N).toCharArray();
           int count = 0;
           for(int i=0; i<ch.length; i++) {
              if(ch[i] == '7') {
                 count++;
              } else if(ch[i] == '4') {
                 count++;
              }
           }
           
           if(count == ch.length) {
              System.out.println(N);
              break;
           }          
           N--;
        }
   }
}