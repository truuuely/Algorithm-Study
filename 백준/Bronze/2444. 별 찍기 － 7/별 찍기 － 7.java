import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String s = "";
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            sb.append(" ".repeat(n - i));
            sb.append("*".repeat(2 * i - 1)).append("\n");
        }

        for (int i = 1; i < n; i++) {
            sb.append(" ".repeat(i));
            sb.append("*".repeat((n - i) * 2 - 1)).append("\n");
        }

        System.out.println(sb);
    }
}