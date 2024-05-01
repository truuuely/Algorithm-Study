import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + (sc.nextInt() + sc.nextInt()));
        }
    }
}