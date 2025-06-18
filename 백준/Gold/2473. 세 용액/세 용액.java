import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 3 이상 5000 이하
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Long> list = new ArrayList<>(); // 최소 -10억, 최대 10억
        for (int i = 0; i < N; i++) {
            list.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(list);

        // 0에 가까우면
        long sum = Long.MAX_VALUE;
        long[] ans = new long[3];
        for (int i = 0; i < N - 2; i++) {
            Long one = list.get(i);

            int left = i + 1, right = N - 1;
            while (left < right) {
                // 합의 절댓값이 더 작은 거 저장
                long candidate = one + list.get(left) + list.get(right);

                // 원래 합과 새로 계산한 합 중에 더 작은게 정답 후보
                if (Math.abs(candidate) < sum) {
                    ans = new long[]{one, list.get(left), list.get(right)};
                    sum = Math.abs(candidate);
                }

                if (candidate == 0) {
                    break;
                } else if (candidate > 0) {
                    right -= 1;
                } else {
                    left += 1;
                }
            }

            if (sum == 0) {
                break;
            }
        }

        // 정답은 오름차순으로 출력
        Arrays.stream(ans).forEach(l -> System.out.print(l + " "));

    }

}