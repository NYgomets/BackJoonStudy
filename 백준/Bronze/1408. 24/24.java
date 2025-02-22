import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		int num2 = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), ":");
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		num = (h * 3600) + (m * 60) + s;
		
		st = new StringTokenizer(br.readLine(), ":");
		h = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		num2 = (h * 3600) + (m * 60) + s;

		int time = 0;
		if(num2 > num) {
			time = num2 - num;
		}else {
			time = (24 * 3600) - (num - num2);
		}	
		System.out.format("%02d:%02d:%02d", (time / 3600), ((time / 60) % 60), (time % 60));
	}
}