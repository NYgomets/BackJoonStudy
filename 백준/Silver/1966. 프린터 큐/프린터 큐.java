import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스
        int testCase = Integer.parseInt(br.readLine());
        for (int i=0; i<testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //queue의 원소 갯수
            int N = Integer.parseInt(st.nextToken());
            //뽑고자 하는 원소의 index
            int M = Integer.parseInt(st.nextToken());

            //queue에 원소(중요도) 및 index 추가
            LinkedList<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
               queue.add(new int[] {Integer.parseInt(st.nextToken()), j});
            }

            int count = 0;

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                boolean max = true;

                for (int k=0; k<queue.size(); k++) {
                    if (poll[0] < queue.get(k)[0]){
                        queue.add(poll);
                        for (int l=0; l<k; l++) {
                            queue.add(queue.poll());
                        }
                        max = false;
                        break;
                    }
                }

                if (max == false) {
                    continue;
                }

                count++;
                if (poll[1] == M) {
                    break;
                }
            }


            System.out.println(count);
        }
    }
}