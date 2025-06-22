import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());

      /*
        현재 몸무게 x, 이전 몸무게 y 라고 했을 때,
        x = y + a 라고 할 수 있다 (a는 자연수)
        x^2 = (y + a)^2 = y^2 + 2ya + a^2 이므로, G = x^2 - y^2 = a * (2y + a) 이다.
        즉 G = a * (2y + a) 를 만족하는 자연수 a와 y를 구한다.
        */
        List<Integer> arr = new ArrayList<>();
        int a = 1, y = 1;
        while (a * a <= 100000) { // G = a(2y+a) 이고 a^2 < a(2y+a) 이므로 대략 이정도
            int curG = a * (2 * y + a);
            if (curG >= G) {
                if (curG == G) {
                    arr.add(y + a);
                }

                // 크거나 같으면 y를 늘려봤자 curG가 더 커지므로 a의 다음 경우의 수를 체크
                a += 1;
                y = 1;
            } else { // (curG < G)
                // y를 늘린다
                y += 1;
            }
        }

        if (arr.isEmpty()) {
            System.out.println(-1);
        } else {
            arr.stream().sorted().forEach(System.out::println);
        }
    }
}