import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int subject = scanner.nextInt();
        int[] score = new int[subject];
        double sum = 0;
        double avg = 0;

        for (int i=0; i<score.length; i++) {
            score[i] = scanner.nextInt();
        }

        int max = score[0];

        for (int i =0; i<score.length; i++) {
            if (max < score[i]) {
                max = score[i];
            }
        }

        for (int i=0; i<score.length; i++) {
            sum += score[i] / (double)max * 100;
        }

        avg = sum / subject;

        System.out.println(avg);

    }
}