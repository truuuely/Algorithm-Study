import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            x -= sc.nextInt() * sc.nextInt();
        }

        System.out.println(x == 0 ? "Yes" : "No");
    }
}
