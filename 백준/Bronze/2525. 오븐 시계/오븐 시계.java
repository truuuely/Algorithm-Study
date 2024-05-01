import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int inputMin = sc.nextInt(); // 0 ~ 1000

        int totalMin = h * 60 + m + inputMin;

        int res = totalMin >= 24 * 60 ? totalMin - 24 * 60 : totalMin;

        System.out.println(res / 60 + " " + res % 60);
    }
}