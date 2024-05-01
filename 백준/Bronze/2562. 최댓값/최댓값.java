import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];
        int max = -1;
        int indexOfMax = -1;
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > max) {
                max = arr[i];
                indexOfMax = i;
            }
        }
        System.out.println(max + "\n" + (indexOfMax + 1));
    }
}