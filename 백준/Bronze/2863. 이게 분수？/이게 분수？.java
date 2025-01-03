import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double[] arr = new double[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		double a = Double.parseDouble(st.nextToken());
		double b = Double.parseDouble(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		double c = Double.parseDouble(st.nextToken());
		double d = Double.parseDouble(st.nextToken());
		
		arr[0] = (a / c) + (b / d);
		arr[1] = (c / d) + (a / b);
		arr[2] = (d / b) + (c / a);
		arr[3] = (b / a) + (d / c);
		
		double max = 0;
		int n = 0;
		
		for(int i = 0; i < 4; i++) {
			if(max < arr[i]) {
				max = arr[i];
				n = i;
			}
		}
		System.out.println(n);
	}
}