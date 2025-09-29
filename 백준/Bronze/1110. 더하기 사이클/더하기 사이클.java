import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int newNum = n;
        int cycle = 0;
        while (true) {
            cycle ++;
            newNum = Integer.parseInt(String.valueOf(newNum % 10) + String.valueOf((newNum / 10 + newNum % 10) % 10));
            if (newNum == n) {
                System.out.println(cycle);
                break;
            }
        }
    }
}