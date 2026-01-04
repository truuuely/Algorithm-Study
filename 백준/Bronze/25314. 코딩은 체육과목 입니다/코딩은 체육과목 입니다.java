import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String prefix = "";
        for (int i = 0; i < n / 4; i++) {
            prefix += "long ";
        }

        System.out.println(prefix + "int");
    }
}