import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    /**
     * 주어진 숫자를 '전반적으로' 파악 후 숫자의 세트를 고민해야함
     * 숫자를 하나하나 확인한다면 반례가 생길 수 있음
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10];

        while (n != 0) {
            int each = n % 10;
            if (each == 9) { // 6과 9 통합 계산
                arr[6]++;
            }
            else {
                arr[each]++;
            }

            n /= 10;
        }

        // 6, 9 세트 통합 처리
        arr[6] = (int) Math.round(arr[6] / 2.0);

        System.out.println(Arrays.stream(arr).max().getAsInt());

    }
}