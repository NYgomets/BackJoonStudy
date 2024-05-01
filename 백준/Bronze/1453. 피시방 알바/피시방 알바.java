import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		boolean[] arr = new boolean[101];

		int backCount = 0;

		for (int i = 0; i < num; i++) {
			int request = s.nextInt();
			if (arr[request] == true) {
				backCount++;
			} else {
				arr[request] = true;
			}
		}
		System.out.println(backCount);
	}
}