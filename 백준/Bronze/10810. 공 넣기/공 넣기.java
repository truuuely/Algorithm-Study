import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] baskets = new int[n + 1];
        for (int a = 0; a < m; a++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();

            for (int b = i; b <= j; b++) {
                baskets[b] = (Integer) k;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.print(baskets[i] + " ");
        }
    }
}
