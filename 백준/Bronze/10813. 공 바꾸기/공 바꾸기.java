import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] baskets = new int[n + 1];

        for (int i = 1; i < baskets.length; i++) {
            baskets[i] = i;
        }

        for (int a = 0; a < m; a++) {
            int i = sc.nextInt();
            int j = sc.nextInt();

             int tmp = baskets[i];
             baskets[i] = baskets[j];
             baskets[j] = tmp;
        }

        for (int i = 1; i < baskets.length; i++) {
            System.out.print(baskets[i] + " ");
        }
    }
}
