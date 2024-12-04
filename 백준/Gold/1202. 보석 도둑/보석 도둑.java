import java.io.*;
import java.util.*;

public class Main {
    static long n; // 보석의 개수
    static long k; // 가방의 개수
    static long[][] arr; // 보석 (무게, 가격)
    static long[] weight; // 가방의 최대 무게
    static long result = 0; // 최대 가격 합계

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 보석의 개수와 가방의 개수 입력
        n = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());

        arr = new long[(int)n][2]; // 보석 (무게, 가격)

        // 보석 정보 입력
        for (long i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[(int)i][0] = Long.parseLong(st.nextToken()); // 무게
            arr[(int)i][1] = Long.parseLong(st.nextToken()); // 가격
        }

        weight = new long[(int)k]; // 가방의 최대 무게

        // 가방 정보 입력
        for (long i = 0; i < k; i++) {
            weight[(int)i] = Long.parseLong(br.readLine());
        }

        // 보석은 무게 오름차순, 가격 내림차순으로 정렬
        Arrays.sort(arr, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[0] == o2[0]) {
                    return Long.compare(o2[1], o1[1]);
                } else {
                    return Long.compare(o1[0], o2[0]);
                }
            }
        });

        // 가방은 무게 오름차순으로 정렬
        Arrays.sort(weight);

        // 우선순위 큐 사용 (가격 내림차순)
        Queue<Long> queue = new PriorityQueue<>(Collections.reverseOrder());
        long idx = 0;

        // 각 가방에 대해 보석을 넣을 수 있는지 확인
        for (long i = 0; i < k; i++) {
            long bag = weight[(int)i]; // 현재 가방의 최대 무게

            // 현재 가방에 넣을 수 있는 보석을 우선순위 큐에 넣기
            while (idx < n && arr[(int)idx][0] <= bag) {
                queue.add(arr[(int)idx][1]); // 해당 보석의 가격을 우선순위 큐에 삽입
                idx++;
            }

            // 큐에서 가장 높은 가격의 보석을 선택하여 가방에 넣기
            if (!queue.isEmpty()) {
                result += queue.poll(); // 가방에 넣고, 그 보석은 제거
            }
        }

        // 최대 가격 출력
        System.out.println(result);
    }
}
