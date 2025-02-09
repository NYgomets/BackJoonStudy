import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String N = br.readLine();
        String[] b = {"000","001","010","011","100","101","110","111"};

        if(N.equals("0")){
            System.out.print(N);
            return;
        }

        for(int n = 0; n < N.length(); n++){
            int idx = N.charAt(n) - '0';
            sb.append(b[idx]);
        }

        while(sb.charAt(0) == '0'){
            sb = new StringBuilder(sb.substring(1));
        }

        System.out.print(sb);
    }
}