import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<String, List<Integer>> nation = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());  // 국가 번호
            int g = Integer.parseInt(st.nextToken());  // 금메달 수
            int s = Integer.parseInt(st.nextToken());  // 은메달 수
            int b = Integer.parseInt(st.nextToken());  // 동메달 수

            String key = g + "," + s + "," + b;
            nation.putIfAbsent(key, new ArrayList<>());
            nation.get(key).add(n);
        }

        List<String> record = new ArrayList<>(nation.keySet());
        Collections.sort(record, (a, b) -> {
            String[] aArr = a.split(",");
            String[] bArr = b.split(",");
            for (int i = 0; i < 3; i++) {
                int diff = Integer.parseInt(bArr[i]) - Integer.parseInt(aArr[i]);
                if (diff != 0) return diff;
            }
            return 0;
        });

        int ret = 1;
        for (String rec : record) {
            List<Integer> countries = nation.get(rec);
            for (int country : countries) {
                if (country == K) {
                    System.out.println(ret);
                    return;
                }
            }
            ret += countries.size();
        }
    }
}
