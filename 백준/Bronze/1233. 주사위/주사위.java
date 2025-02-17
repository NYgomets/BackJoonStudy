import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int[] num = new int[Integer.parseInt(arr[0])];
        int[] num2 = new int[Integer.parseInt(arr[1])];
        int[] num3 = new int[Integer.parseInt(arr[2])];
        int res = 0;
        
        for (int i = 0; i < num.length; i++) {
			num[i] = i + 1;
		}
		for (int i = 0; i < num2.length; i++) {
			num2[i] = i + 1;
		}
		for (int i = 0; i < num3.length; i++) {
			num3[i] = i + 1;
		}

		int sum[] = new int[81];
		for (int i = 0; i < Integer.parseInt(arr[0]); i++) {
			for (int j = 0; j < Integer.parseInt(arr[1]); j++) {
				for (int k = 0; k < Integer.parseInt(arr[2]); k++) {
					sum[num[i] + num2[j] + num3[k]]++;
				}
			}
		}

		int key = 0;
		for (int i = 0; i < sum.length; i++) {
			key = Math.max(key, sum[i]);
		}
		for (int i = 0; i < sum.length; i++) {
			if (key == sum[i]) {
				res = i;
				break;
			}
		}
		System.out.println(res);
    }
}