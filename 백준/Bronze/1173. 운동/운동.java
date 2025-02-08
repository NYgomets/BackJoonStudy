import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int cnt2 = 0;
        int m2 = m;

        while(cnt2 != N){

            if(m + T <= M){
                m += T;
                cnt2++;
            }else{
                m -= R;
                if(m < m2){
                    m = m2;
                }
            }
            cnt++;
            if((m + T > M) && (m == m2)){
                break;
            }
        }

        if(cnt2 != N){
            System.out.print(-1);
        }else{
            System.out.print(cnt);
        }
    }
}
