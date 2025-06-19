import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 부분합이 M이 되는 경우의 수 구하기
        // 수열의 값은 3만을 넘지 않는 자연수
        int n = Integer.parseInt(st.nextToken()); // 1만
        int m = Integer.parseInt(st.nextToken()); // 최대 3억

        int[] prefixSum = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int left = 0, right = 1;

        // 시간제한 0.5초 -> 투 포인터 사용
        while (right <= n) { // 최대 n까지
            int sub = prefixSum[right] - prefixSum[left]; // left 초과 right 이하의 부분합

            // 수열 값이 1 이상이므로 항상 prefixSum[i] < prefixSum[i+1]
            if (sub == m) {
                cnt += 1;
                right += 1;
            } else if (sub > m) {
                left += 1;
            } else {
                right += 1;
            }
        }

        System.out.println(cnt);
    }
}