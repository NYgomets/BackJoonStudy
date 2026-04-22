import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());

            double totalPrice = 0;
            double min = Double.MAX_VALUE;

            int answer = 0;
            for (int j = 0; j < num; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int gram = Integer.parseInt(st.nextToken());
                int price = Integer.parseInt(st.nextToken());

                totalPrice = (double) price / gram;

                if (min > totalPrice ){
                    min = totalPrice;
                    answer = (int)price;
                }else if (totalPrice == min && price < answer){
                    answer = price;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}