import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        int res = 0;
        if (n1 == n2 && n2 == n3) {
            res = 10000 + n1 * 1000;
        } else if (n1 == n2 || n2 == n3 || n1 == n3) {
            int sameNum = n1;
            if (n2 == n3) {
                sameNum = n2;
            }
            res = 1000 + sameNum * 100;
        }
        else {
            int max = Math.max(n1, n2) > n3 ? Math.max(n1, n2) : n3;
            res = max * 100;
        }

        System.out.println(res);
    }
}