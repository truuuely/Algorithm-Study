import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();

        for (int i = 0; i < C; i++) {
            int N = sc.nextInt();

            int[] scores = new int[N];

            int totalSum = 0;

            for (int j = 0; j < N; j++) {
                scores[j] = sc.nextInt();
                totalSum += scores[j];
            }

            double average = (double) totalSum / N;

            int countOverAverage = 0;
            for (int score : scores) {
                if (score > average) {
                    countOverAverage++;
                }
            }

            double ratio = (double) countOverAverage / N * 100;

            System.out.printf("%.3f%%\n", ratio);
        }
    }
}